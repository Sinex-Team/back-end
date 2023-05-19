package ua.lviv.iot.sinex.security.hygrometer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.sinex.security.models.Hygrometer;


@Repository
public interface HygrometerRepository extends JpaRepository<Hygrometer, Integer> {
    @Query("SELECT h.id FROM Hygrometer h ORDER BY h.id DESC")
    Integer findTopByOrderByIdDesc();
}
