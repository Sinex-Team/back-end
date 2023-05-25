package ua.lviv.iot.sinex.security.models.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByUsername(String email){
        return userRepository.findByEmail(email);
    }
}
