package ua.lviv.iot.sinex.security.hygrometer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.sinex.security.models.Hygrometer;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/hygrometers")
public class HygrometerController {
    private final HygrometerService hygrometerService;

    @Autowired
    public HygrometerController(HygrometerService hygrometerService) {
        this.hygrometerService = hygrometerService;
    }

    @PostMapping("/")
    public ResponseEntity<Hygrometer> save(@RequestBody Hygrometer hygrometer) {
        if (hygrometer.getId() == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        if (hygrometerService.existById(hygrometer.getId())) {
        } else {
            return ResponseEntity.badRequest().build();
        }
        Integer id = hygrometerService.findTopByOrderByIdDesc();
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        hygrometer.setId(id);
        hygrometer.setDateAndTime(LocalDateTime.now().withNano(0));
        hygrometerService.saveHygrometer(hygrometer);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/id")
    public ResponseEntity<Integer> returnId() {
        Hygrometer hygrometerWithNullData = new Hygrometer();
        Integer id = hygrometerService.createId(hygrometerWithNullData);
        return ResponseEntity.ok(id);
    }
}
