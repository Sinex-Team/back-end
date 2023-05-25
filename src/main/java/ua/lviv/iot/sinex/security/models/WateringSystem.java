package ua.lviv.iot.sinex.security.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.lviv.iot.sinex.security.models.user.User;

import java.util.List;
import java.util.Map;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WateringSystem {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer countOhHygrometers;

    private String defaultName = "Aquamole watering system";

    private String ownerNameAndSurname;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToMany
//    private List<Hygrometer> hygrometer;
}
