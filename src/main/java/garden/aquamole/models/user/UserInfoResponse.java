package garden.aquamole.models.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserInfoResponse {
    private String firstname;
    private String lastname;
    private String email;
}
