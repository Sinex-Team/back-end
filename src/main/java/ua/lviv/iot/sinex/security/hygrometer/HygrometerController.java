package ua.lviv.iot.sinex.security.hygrometer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.sinex.security.models.Hygrometer;

@RestController
@RequestMapping("/hygrometer")
public class HygrometerController {
    private final HygrometerService hygrometerService;

    @Autowired
    public HygrometerController(HygrometerService hygrometerService) {
        this.hygrometerService = hygrometerService;
    }

    @PostMapping("/read")
    public Hygrometer readData (@RequestBody Hygrometer hygrometer){
        hygrometerService.saveHygrometer(hygrometer);
        return hygrometer;
    }
}
