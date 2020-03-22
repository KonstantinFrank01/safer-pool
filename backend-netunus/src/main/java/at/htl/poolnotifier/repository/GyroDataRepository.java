package at.htl.poolnotifier.repository;

import at.htl.poolnotifier.entity.GyroData;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GyroDataRepository {

    @Inject
    EntityManager em;

    @Transactional
    public GyroData persistData(GyroData gyroData) {
        return em.merge(gyroData);
    }

    public List<GyroData> getAllData(int limit) {
        return em.createNamedQuery("GyroData.getAllData", GyroData.class)
                .setMaxResults(limit)
                .getResultList();
    }

    public List<GyroData> getAllData() {
        return em.createNamedQuery("GyroData.getAllData", GyroData.class)
                .getResultList();
    }
}
