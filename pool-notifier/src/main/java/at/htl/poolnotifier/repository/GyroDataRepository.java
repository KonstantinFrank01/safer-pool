package at.htl.poolnotifier.repository;

import at.htl.poolnotifier.entity.GyroData;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class GyroDataRepository {

    @Inject
    EntityManager em;

    @Transactional
    public GyroData persistData(GyroData gyroData) {
        return em.merge(gyroData);
    }
}
