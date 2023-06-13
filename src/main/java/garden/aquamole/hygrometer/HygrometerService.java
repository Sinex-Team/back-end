package garden.aquamole.hygrometer;

import garden.aquamole.models.ResponseHygrometerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import garden.aquamole.models.Hygrometer;

import java.util.List;

@Service
public class HygrometerService {
    private final HygrometerRepository hygrometerRepository;

    @Autowired
    public HygrometerService(HygrometerRepository hygrometerRepository) {
        this.hygrometerRepository = hygrometerRepository;
    }
    public ResponseHygrometerId createId(Hygrometer hygrometerWithNullData) {
        hygrometerRepository.save(hygrometerWithNullData);
        ResponseHygrometerId hygrometerId = new ResponseHygrometerId();
        hygrometerId.setId(hygrometerWithNullData.getId());
        return hygrometerId;
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

    public List<Hygrometer> findAll(){
        return hygrometerRepository.findAll();
    }

}
