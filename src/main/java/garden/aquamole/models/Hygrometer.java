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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hygrometer")
public class Hygrometer {
    @Id
    @GeneratedValue
    private Integer id;
    @Pattern(regexp = "^(?:100|[1-9]?[0-9])%$\n")
    private Integer humidity;
    private LocalDateTime dateAndTime;
}
