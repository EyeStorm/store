package com.tiagohs;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApplication {

  public static void main(String[] args) {
    Application.launch(SplashScreen.class, args);
  }

}
