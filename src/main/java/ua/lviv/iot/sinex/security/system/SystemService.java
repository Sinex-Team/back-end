package ua.lviv.iot.sinex.security.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemService {
    @Autowired
    private SystemRepository systemRepository;

    public System save(System system){
        return systemRepository.save(system);
    }
}
