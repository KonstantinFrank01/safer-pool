package at.htl.poolnotifier.repository;

import at.htl.poolnotifier.entity.GyroData;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GyroDataRepository implements PanacheRepository<GyroData> {
}
