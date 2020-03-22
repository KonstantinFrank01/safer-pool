package at.htl.netunus.entity;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "GyroData.getAllData",
                query = "select gd from GyroData gd order by gd.id desc "
        )
})
public class GyroData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public double x;
    public double y;
    public double z;
    public String location;
    public LocalDateTime notificationTime;

    public GyroData(double x, double y, double z, String location) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.location = location;
        this.notificationTime = LocalDateTime.now();
    }

    public GyroData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(LocalDateTime notificationTime) {
        this.notificationTime = notificationTime;
    }

    @Override
    public String toString() {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(this);
    }
}
