package perc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import perc.entities.TempOfLocationEntity;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface PersentilRepository extends JpaRepository<TempOfLocationEntity, Integer> {
    List<TempOfLocationEntity> findByLocationid(Integer locationId);

    List<TempOfLocationEntity> findByLocationidAndTemperature(Integer locationId, Integer count);


}
