package at.htl.poolnotifier.boundary;

import at.htl.poolnotifier.entity.GyroData;
import at.htl.poolnotifier.repository.GyroDataRepository;
import at.htl.poolnotifier.service.DeactivationService;
import io.smallrye.reactive.messaging.annotations.Channel;
import io.vertx.core.eventbus.Message;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pool")
public class GyroDataEndpoint {

    @Inject
    GyroDataRepository gyroDataRepository;

    @Inject
    DeactivationService deactivationService;

    @Inject
    @Channel("pool-alarm")
    Publisher<Message<GyroData>> alarmData;

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
    public Publisher<Message<GyroData>> stream() {
        return alarmData;
    }

    @PUT
    @Path("/deactivate")
    public Response setAlarmStatus(@QueryParam("duration") Integer duration) {
        if (duration == null || duration < 0) {
            return Response.status(400).build();
        }
        deactivationService.deactivate(duration);
        return Response.noContent().build();
    }
}
