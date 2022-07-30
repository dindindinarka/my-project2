package perc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import perc.services.ProfilerCustom;


@SpringBootApplication
public class PercentillApplication {
    @ProfilerCustom
    public static void main(String[] args) {
        SpringApplication.run(PercentillApplication.class, args);
    }


}
