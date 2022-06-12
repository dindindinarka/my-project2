package perc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import perc.entities.TempOfLocationEntity;

import java.util.List;


@Repository
public interface PersentilRepository extends JpaRepository<TempOfLocationEntity, String> {
    List<TempOfLocationEntity> findByLocationid(Integer locationId);
}
