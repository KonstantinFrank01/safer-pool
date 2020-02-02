package at.htl.poolnotifier.boundary;

import at.htl.poolnotifier.entity.GyroData;
import at.htl.poolnotifier.repository.GyroDataRepository;
import io.smallrye.reactive.messaging.annotations.Channel;
import org.reactivestreams.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pool")
public class GyroDataEndpoint {

    @Inject
    GyroDataRepository gyroDataRepository;

    @Inject
    @Channel("pool-alarm")
    Publisher<GyroData> alarmData;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllData(@QueryParam("limit") Integer limit) {
        if (limit == null || limit < 0) {
            return Response.ok(gyroDataRepository.getAllData()).build();
        }
        return Response.ok(gyroDataRepository.getAllData(limit)).build();
    }


    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Publisher<GyroData> stream() {
        return alarmData;
    }
}
