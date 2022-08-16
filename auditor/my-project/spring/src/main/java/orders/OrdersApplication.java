package orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import perc.services.ProfilerCustom;


@SpringBootApplication
public class OrdersApplication {
    @ProfilerCustom
    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class, args);
    }


}
