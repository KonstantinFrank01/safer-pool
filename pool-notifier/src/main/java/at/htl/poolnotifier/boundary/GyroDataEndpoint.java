package at.htl.poolnotifier.boundary;

import at.htl.poolnotifier.entity.GyroData;
import io.smallrye.reactive.messaging.annotations.Channel;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("pool")
public class GyroDataEndpoint {

    @Inject
    @Channel("pool-alarm")
    Publisher<GyroData> alarmData;

    @GET
    public String hello() {
        return "Hello World";
    }

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Publisher<GyroData> stream() {
        return alarmData;
    }
}
