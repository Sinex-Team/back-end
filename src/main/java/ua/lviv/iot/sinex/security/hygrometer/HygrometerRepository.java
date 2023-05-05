package ua.lviv.iot.sinex.security.hygrometer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.sinex.security.models.Hygrometer;

@Repository
public interface HygrometerRepository extends JpaRepository<Hygrometer, Integer> {

}
