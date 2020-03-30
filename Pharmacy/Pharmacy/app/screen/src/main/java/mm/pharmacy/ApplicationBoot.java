package mm.pharmacy;

import javafx.application.Application;
import mm.pharmacy.screen.application.SplashBoot;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationBoot {

  public static void main(String[] args) {
    Application.launch(SplashBoot.class, args);
  }
}
