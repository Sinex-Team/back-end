package ua.lviv.iot.sinex.security.wateringSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.sinex.security.models.WateringSystem;

import java.util.List;

public interface WateringSystemRepository extends JpaRepository<WateringSystem,Integer> {

}
