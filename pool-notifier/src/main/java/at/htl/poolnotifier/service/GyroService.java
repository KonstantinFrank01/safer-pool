package at.htl.poolnotifier.service;

import at.htl.poolnotifier.entity.GyroData;
import at.htl.poolnotifier.repository.GyroDataRepository;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.reactive.streams.operators.ReactiveStreams;
import org.reactivestreams.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class GyroService {

    @Inject
    GyroDataRepository gyroDataRepository;

    Jsonb jsonb;

    public GyroService() {
        jsonb = JsonbBuilder.create();
    }

    @Incoming("pool")
    @Outgoing("pool-process")
    public Publisher<GyroData> consumeData(byte[] rawData) {
        String data = new String(rawData);
        GyroData gyroData = null;
        try {
            gyroData = jsonb.fromJson(data, GyroData.class);
            gyroData.setNotificationTime(LocalDateTime.now());
        } catch (JsonbException ignored) {
        }

        return ReactiveStreams.ofNullable(gyroData).buildRs();
    }

    @Incoming("pool-process")
    @Outgoing("pool-alarm")
    public CompletionStage<GyroData> persistData(GyroData gyroData) {
        return CompletableFuture.supplyAsync(() -> gyroDataRepository.persistData(gyroData));
    }
}
