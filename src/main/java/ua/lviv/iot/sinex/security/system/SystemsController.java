package ua.lviv.iot.sinex.security.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/systems")
public class SystemsController {

    @Autowired
    private SystemRepository systemRepository;

    @PostMapping
    public ResponseEntity<System> saveSystem(@RequestBody System system){
        return ResponseEntity.ok(systemRepository.save(system));
    }
}
