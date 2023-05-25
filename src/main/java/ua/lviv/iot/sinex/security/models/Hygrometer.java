package ua.lviv.iot.sinex.security.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.lviv.iot.sinex.security.models.user.User;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_hygrometer")
public class Hygrometer {
    @Id
    @GeneratedValue
    private Integer id;
    private String humidity;
    private LocalDateTime dateAndTime;

}
