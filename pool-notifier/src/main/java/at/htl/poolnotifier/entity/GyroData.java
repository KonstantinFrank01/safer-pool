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
}
