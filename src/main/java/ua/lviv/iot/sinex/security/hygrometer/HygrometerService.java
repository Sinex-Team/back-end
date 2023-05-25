package ua.lviv.iot.sinex.security.hygrometer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.sinex.security.models.Hygrometer;

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
}
