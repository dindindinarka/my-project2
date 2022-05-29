package docs.entities;

import docs.enums.StatusTypes;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;


@Data
@Entity
@Table(name = "documents")
public class DocumentsEntity {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusTypes status;

    private String username;

    private Instant deletedat;

    public DocumentsEntity() {
        super();
    }

    public DocumentsEntity(Long id, StatusTypes status, String username, Instant deletedat) {
        super();
        this.id = id;
        this.status = status;
        this.username = username;
        this.deletedat = deletedat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public StatusTypes getStatus() {
        return status;
    }

    public void setStatus(StatusTypes status) { this.status = status;
    }

    public Instant getDeletedAt() {
        return deletedat;
    }

    public void setDeletedAt(Instant deletedat) {
        this.deletedat = deletedat;
    }

}
