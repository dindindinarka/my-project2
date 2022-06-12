package perc.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "location")
public class LocationEntity {

    @Id
    private int id;
    private  String locationname;



}
