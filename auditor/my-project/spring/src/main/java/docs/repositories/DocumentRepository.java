package docs.repositories;

import docs.entities.DocumentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;


@Repository
public interface DocumentRepository extends JpaRepository<DocumentsEntity, Long> {

    List<DocumentsEntity> findByIdIn(Set<Long> ids);

    @Modifying
    @Transactional
    @Query(value = "update documents set deletedAt = now() where id in (?1)", nativeQuery = true)
    int update(List<Long> ids);


}
