package docs.dto;

import docs.entities.DocumentsEntity;
import lombok.Data;

import java.util.List;

@Data
public class DocDataResponse {

    private List<DocumentsEntity> result;

}

