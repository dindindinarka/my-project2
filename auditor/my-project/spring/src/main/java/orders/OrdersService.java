package orders;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import perc.entities.TempOfLocationEntity;
import perc.repositories.LocationRepository;
import perc.repositories.PersentilRepository;
import perc.services.ProfilerCustom;

import java.util.HashMap;
import java.util.List;


@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private ObjectMapper objectMapper;


    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;

    }

    @ProfilerCustom
    public OrdersEntity create(String name, String adress, Content content) {

        OrdersEntity newOrder = new OrdersEntity();
        newOrder.setName(name);
        newOrder.setAdress(adress);
        newOrder.setContents(content);
        ordersRepository.save(newOrder);
        return newOrder;
    }


    @ProfilerCustom
    public Content getOrdersByContent(String content) throws JsonProcessingException {
        Content contentBody = objectMapper.readValue(content, Content.class);
        return contentBody;

    }

    public List<OrdersEntity> getAllOrders() {
        List<OrdersEntity> orders = ordersRepository.findAll();
        return orders;
    }

}


