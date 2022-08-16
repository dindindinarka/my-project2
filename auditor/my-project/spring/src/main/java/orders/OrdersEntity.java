package orders;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity
@Table(name = "orders", schema = "public")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class OrdersEntity {

    @Id
    @GeneratedValue(generator = "uuid_generate_v4")
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;
    @Column(name = "adress")
    private String adress;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Content contents;


}
