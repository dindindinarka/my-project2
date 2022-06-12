package perc.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "tempoflocation")
public class TempOfLocationEntity {

    @Id
    private int temperature;
    private int locationid;



}
