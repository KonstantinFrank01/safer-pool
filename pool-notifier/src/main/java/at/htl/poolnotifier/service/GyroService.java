package at.htl.poolnotifier.service;

import at.htl.poolnotifier.entity.GyroData;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GyroService {

    @Incoming("pool")
    @Outgoing("pool-alarm")
    public GyroData validateData(byte[] rawData) {
        String data = new String(rawData);
        System.out.println(data);
        return new GyroData(0, 0, 0, "pool1");
    }
}
