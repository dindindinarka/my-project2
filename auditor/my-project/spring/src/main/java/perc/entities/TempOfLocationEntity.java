package perc.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Table(name = "tempoflocation")
public class TempOfLocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    private int id;
    private int temperature;
    private int locationid;
    private int counttemp;



}
