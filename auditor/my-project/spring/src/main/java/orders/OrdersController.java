package orders;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/{orders}")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping()
    public ResponseEntity<OrdersEntity> createOrder(
            @RequestParam String name,
            @RequestParam String adress,
            @RequestBody Content content) {
        return ResponseEntity.ok(ordersService.create(name, adress, content));

    }

    @GetMapping()
    public ResponseEntity<List<OrdersEntity>> getOrdersByName(
            @RequestParam String name) {
        return ResponseEntity.ok(ordersService.getAllOrders());

    }

}
