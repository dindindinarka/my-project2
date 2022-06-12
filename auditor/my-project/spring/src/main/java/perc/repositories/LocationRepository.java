package perc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import perc.entities.LocationEntity;

import java.util.List;


@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {

    List<LocationEntity> findAll();


}
