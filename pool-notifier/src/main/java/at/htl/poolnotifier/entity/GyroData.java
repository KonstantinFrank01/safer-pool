package at.htl.poolnotifier.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.time.LocalDateTime;

public class GyroData extends PanacheEntity {
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
}
