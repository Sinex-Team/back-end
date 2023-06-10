package garden.aquamole.hygrometer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import garden.aquamole.models.Hygrometer;

@Service
public class HygrometerService {
    private final HygrometerRepository hygrometerRepository;

    @Autowired
    public HygrometerService(HygrometerRepository hygrometerRepository) {
        this.hygrometerRepository = hygrometerRepository;
    }
    public Integer createId(Hygrometer hygrometerWithNullData) {
        hygrometerRepository.save(hygrometerWithNullData);
        return hygrometerWithNullData.getId();
    }

    public Integer findTopByOrderByIdDesc() {
        return hygrometerRepository.findTopByOrderByIdDesc();
    }

    public void saveHygrometer(Hygrometer hygrometer) {
        hygrometerRepository.save(hygrometer);
    }

    public boolean existById(Integer id) {
        return hygrometerRepository.existsById(id);
    }

    public Hygrometer getById(Integer id){
        return hygrometerRepository.getById(id);
    }

}
