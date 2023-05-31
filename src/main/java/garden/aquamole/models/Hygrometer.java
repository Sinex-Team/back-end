package garden.aquamole.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Pattern(regexp = "^(?:100|[1-9]?[0-9])%$\n")
    private String humidity;
    private LocalDateTime dateAndTime;

}
