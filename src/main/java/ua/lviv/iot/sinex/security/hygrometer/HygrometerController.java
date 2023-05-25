package ua.lviv.iot.sinex.security.hygrometer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.sinex.security.config.JwtService;
import ua.lviv.iot.sinex.security.models.Hygrometer;
import ua.lviv.iot.sinex.security.models.user.User;
import ua.lviv.iot.sinex.security.models.user.UserRepository;
import ua.lviv.iot.sinex.security.models.user.UserService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/hygrometers")
public class HygrometerController {
    private final HygrometerService hygrometerService;
    private final JwtService jwtService;
    private final UserService userService;

    @Autowired
    public HygrometerController(HygrometerService hygrometerService, JwtService jwtService, UserService userService) {
        this.hygrometerService = hygrometerService;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<Hygrometer> save(@RequestBody Hygrometer hygrometer) {
        if (hygrometer.getId() == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        if (!hygrometerService.existById(hygrometer.getId())) {
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

    @GetMapping("/test")
    public ResponseEntity<?> processRequest(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring(7);
        String userName = jwtService.extractUsername(token);
        var optionalUser = userService.findByUsername(userName);
        return ResponseEntity.ok(optionalUser.get().getId());
    }


    @PostMapping("/id")
    public ResponseEntity<Integer> returnId() {
        Hygrometer hygrometerWithNullData = new Hygrometer();
        Integer id = hygrometerService.createId(hygrometerWithNullData);
        return ResponseEntity.ok(id);
    }
}
