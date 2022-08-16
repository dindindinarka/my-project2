package orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, Integer> {
    List<OrdersEntity> findByName(String name);

    List<OrdersEntity> findByAdress(String adress);


}
