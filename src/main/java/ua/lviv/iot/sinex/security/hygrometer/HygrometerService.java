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

    public void saveHygrometer(Hygrometer hygrometer) {
        hygrometerRepository.save(hygrometer);
    }
}
