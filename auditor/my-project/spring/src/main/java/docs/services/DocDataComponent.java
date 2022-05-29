package docs.services;

import docs.entities.DocumentsEntity;
import docs.repositories.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.Set;


@Repository
@RequiredArgsConstructor
public class DocDataComponent {
    private  final DocumentRepository documentRepository;

    @Transactional
    public void updateDocs (List<Long> ids) {
        documentRepository.update(ids);
    }

    public List<DocumentsEntity> findDocsByIds(Set<Long> ids) {
        return documentRepository.findByIdIn(ids);
    }
}