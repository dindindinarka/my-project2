package profile;

import javax.annotation.PostConstruct;

@ProfileCustom
public class ProfileTest implements ProfileCustomInterface {


    public void setMessage(String message) {
        this.message = message;
    }

    public void init() {
        System.out.println("Инициализация...");
    }

    private String message;

    @Override
    public void printMess() {
        System.out.println(message);

    }
}
