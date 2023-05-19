package ua.lviv.iot.sinex.security.system;

import jakarta.persistence.*;
import lombok.*;
import ua.lviv.iot.sinex.security.models.user.User;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class System {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer countOfHygrometers;

//    @OneToMany(mappedBy = "system", cascade = CascadeType.ALL)
//    private List<Hygrometer> hygrometers;

    @OneToOne
    private User user;
}
