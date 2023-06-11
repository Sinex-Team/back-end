package garden.aquamole.hygrometer;

import garden.aquamole.models.ResponseHygrometerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import garden.aquamole.models.Hygrometer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@CrossOrigin
@RestController
@RequestMapping("/hygrometers")
public class HygrometerController {
    private final HygrometerService hygrometerService;

    @Autowired
    public HygrometerController(HygrometerService hygrometerService) {
        this.hygrometerService = hygrometerService;
    }

    @PostMapping
    public ResponseEntity<Hygrometer> save(@RequestBody Hygrometer hygrometer) {
        if (hygrometer.getId() == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        if(hygrometer.getHumidity() == null){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        if (!hygrometerService.existById(hygrometer.getId())) {
            return ResponseEntity.badRequest().build();
        }
        hygrometer.setDateAndTime(LocalDateTime.now().withNano(0));
        hygrometerService.saveHygrometer(hygrometer);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/id")
    public ResponseEntity<ResponseHygrometerId> returnId() {
        Hygrometer hygrometerWithNullData = new Hygrometer();
        return ResponseEntity.ok(hygrometerService.createId(hygrometerWithNullData));
    }

    @GetMapping("/:{id}")
    public ResponseEntity<Hygrometer> getById(@PathVariable Integer id){
         Hygrometer foundedHygrometer = hygrometerService.getById(id);
         if(foundedHygrometer == null){
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(foundedHygrometer);
    }
}
