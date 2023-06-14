package garden.aquamole.models.user;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserInfoResponse> currentUserNameSimple(HttpServletRequest request) {
        UserInfoResponse userInfoResponse = userService.getUserInfo(request);
        if (userInfoResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userInfoResponse);
    }
}

