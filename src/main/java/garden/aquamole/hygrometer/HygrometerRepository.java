package garden.aquamole.hygrometer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import garden.aquamole.models.Hygrometer;


@Repository
public interface HygrometerRepository extends JpaRepository<Hygrometer, Integer> {

}
