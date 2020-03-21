package at.htl.poolnotifier.service;

import at.htl.poolnotifier.entity.GyroData;
import at.htl.poolnotifier.repository.GyroDataRepository;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import io.smallrye.reactive.messaging.mqtt.ReceivingMqttMessage;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.reactive.streams.operators.PublisherBuilder;
import org.eclipse.microprofile.reactive.streams.operators.ReactiveStreams;

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

    @Inject
    DeactivationService deactivationService;

    Jsonb jsonb;

    public GyroService() {
        jsonb = JsonbBuilder.create();
    }

    @Incoming("pool")
    @Outgoing("pool-alarm")
    @Broadcast
    public PublisherBuilder<Message<GyroData>> consumeData(ReceivingMqttMessage message) {
        String data = new String(message.getPayload());
        Message<GyroData> payload = null;
        if (!deactivationService.isDeactivated()) {
            try {
                GyroData gyroData = jsonb.fromJson(data, GyroData.class);
                gyroData.setNotificationTime(LocalDateTime.now());
                payload = Message.of(gyroData);
            } catch (JsonbException ignored) {
            }
        }
        return ReactiveStreams.ofNullable(payload);
    }

    @Incoming("pool-alarm")
    public CompletionStage<Message<GyroData>> persistData(Message<GyroData> message) {
        GyroData gyroData = message.getPayload();
        return CompletableFuture.supplyAsync(() -> {
            if (gyroData.getX() > 1000.0 || gyroData.getY() > 1000.0 || gyroData.getZ() > 1000.0) {
                return Message.of(gyroDataRepository.persistData(gyroData));
            }

            return Message.of(gyroData);
        });
    }
}
