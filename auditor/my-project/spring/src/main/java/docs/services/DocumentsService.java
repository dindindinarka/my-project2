package docs.services;


import docs.entities.DocumentsEntity;
import docs.enums.ResponseTypes;
import docs.enums.StatusTypes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


@Service
public class DocumentsService {

    private final DocDataComponent docDataComponent;
    List<DocumentsEntity> docList = null;


    public DocumentsService(final DocDataComponent docDataComponent) {
        this.docDataComponent = docDataComponent;
    }

    public List<String> updateDocs(String userName, Set<Long> ids) {
        docList = docDataComponent.findDocsByIds(ids);
        var docListErrors = deleteOtherUsers(userName, ids);
        var docListErrors2 = deleteOfDeleted(ids);
        var docListErrors3 = deleteOfSent(ids);
        var docList1 = docList.stream().map(s -> s.getId() + ResponseTypes.UPDATED.getType()).collect(toList());
        docDataComponent.updateDocs(docList.stream().map(s -> s.getId()).collect(toList()));
        List<String> result = Stream.of(docList1, docListErrors, docListErrors2, docListErrors3)
                .flatMap(x -> x.stream())
                .collect(toList());
        return result;
    }

    public List<String> deleteOtherUsers(String userName, Set<Long> ids) {

        var docsOfAnontherUser = docList.stream().filter(s -> !s.getUserName().equals(userName))
                .collect(toList());
        var result = delete(docsOfAnontherUser, ids, ResponseTypes.USERWRONG.getType());
        return result;

    }

    private List<String> deleteOfSent(Set<Long> ids) {

        var docsOfSent = docList.stream().filter(s -> s.getStatus().equals(StatusTypes.SENT))
                .collect(toList());
        var result = delete(docsOfSent, ids, ResponseTypes.STATUSWRONG.getType());
        return result;

    }

    private List<String> deleteOfDeleted(Set<Long> ids) {
        var docsOfDeleted = docList.stream().filter(s -> (s.getDeletedAt() != null)).collect(toList());
        var result = delete(docsOfDeleted, ids, ResponseTypes.DELETEDATWRONG.getType());
        return result;

    }

    private List<String> delete(List<DocumentsEntity> docs, Set<Long> ids, String errors) {

        var result = new ArrayList<String>(ids.size());

        if (docs.size() != 0) {
            var wrongStatus = docs.stream().map(DocumentsEntity::getId)
                    .map(id -> id.toString() + errors).collect(toList());
            result.addAll(wrongStatus);

        }
        docList.removeAll(docs);
        return result;

    }
}


