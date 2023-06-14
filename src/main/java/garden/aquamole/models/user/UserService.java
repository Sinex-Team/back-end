package garden.aquamole.models.user;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.security.Principal;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserInfoResponse getUserInfo(HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        String email = principal.getName();
        User user = userRepository.findByEmail(email).get();
        return UserInfoResponse.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .build();
    }
}
