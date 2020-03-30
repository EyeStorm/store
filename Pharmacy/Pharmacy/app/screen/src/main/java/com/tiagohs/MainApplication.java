package com.tiagohs;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

  public static void main(String[] args) {
    Application.launch(SplashScreen.class, args);
  }

}
