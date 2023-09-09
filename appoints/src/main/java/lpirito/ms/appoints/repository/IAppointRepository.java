package lpirito.ms.appoints.repository;

import lpirito.ms.appoints.entity.Appoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointRepository extends JpaRepository<Appoint, Long> {
}
