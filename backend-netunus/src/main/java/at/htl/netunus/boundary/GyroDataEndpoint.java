package at.htl.netunus.boundary;

import at.htl.netunus.entity.GyroData;
import at.htl.netunus.repository.GyroDataRepository;
import at.htl.netunus.service.DeactivationService;
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

    //Diese Methode liefert, die bereits in die Datenbank persistierten Auslöser
    //mittels einem QueryParam, limit, kann man die Anzahl, der anzuzeigenden Daten angeben
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllData(@QueryParam("limit") Integer limit) {
        if (limit == null || limit < 0) {
            return Response.ok(gyroDataRepository.getAllData()).build();
        }
        return Response.ok(gyroDataRepository.getAllData(limit)).build();
    }

    //stream von gyroDaten die vom GyroSensor kommen
    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Publisher<Message<GyroData>> stream() {
        return alarmData;
    }

    //Mittels PUT Befehl und QueryParam kann der Alarm, für eine gewisse Zeit deaktiviert werden
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
