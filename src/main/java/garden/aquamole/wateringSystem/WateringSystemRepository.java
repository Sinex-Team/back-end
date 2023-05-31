package garden.aquamole.wateringSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import garden.aquamole.models.WateringSystem;

public interface WateringSystemRepository extends JpaRepository<WateringSystem,Integer> {}
