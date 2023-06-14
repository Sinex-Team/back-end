package garden.aquamole.hygrometer;

import garden.aquamole.models.ResponseHygrometerId;
import lombok.RequiredArgsConstructor;
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
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/hygrometers")
@RequiredArgsConstructor
public class HygrometerController {
    private final HygrometerService hygrometerService;
    private final HygrometerRepository hygrometerRepository;

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
        return ResponseEntity.ok(hygrometer);
    }

    @PostMapping("/id")
    public ResponseEntity<ResponseHygrometerId> returnId() {
        Hygrometer hygrometerWithNullData = new Hygrometer();
        return ResponseEntity.ok(hygrometerService.createId(hygrometerWithNullData));
    }

    @GetMapping("/{id}")
    public Hygrometer getById(@PathVariable Integer id){
        return hygrometerRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Hygrometer>> getAll() {
        return ResponseEntity.ok(hygrometerService.findAll());
    }
}
