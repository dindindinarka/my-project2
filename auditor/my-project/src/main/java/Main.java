import org.springframework.context.support.ClassPathXmlApplicationContext;
import profile.ProfileCustomInterface;

public class Main {
        public static void main (String[] args) {
            var context = new ClassPathXmlApplicationContext("applicationContext.xml");
            context.getBean(ProfileCustomInterface.class).printMess();
        }
}
