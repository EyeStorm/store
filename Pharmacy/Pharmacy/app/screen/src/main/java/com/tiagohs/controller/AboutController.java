package com.tiagohs.controller;

import com.tiagohs.SplashScreen;
import com.tiagohs.util.WindowsUtils;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

@Controller
public class AboutController extends BaseController {

  public static final String PATH_FXML = "/fxml/about.fxml";
  public static final String ABOUT_TITLE_KEY = "about.title";
  public static final String PATH_ICON = WindowsUtils.ICON_APP_PATH;

  public static final String FACCEBOOK_URL = "https://www.facebook.com/tiago.henrique.16";
  public static final String GITHUB_URL = "https://github.com/tiagohs";
  public static final String LINKEDIN_URL = "https://br.linkedin.com/in/tiago-henrique-395868b7";
  public static final String EMAIL_URL = "mailto:tiago.hsilva@al.infnet.edu.br";

  @Override
  public <T> void init(Stage stage, HashMap<String, T> parameters) {
    super.init(stage, parameters);
  }

  @Override
  protected void onClose() {

  }

  @FXML
  public void onFacebook() {
    SplashScreen.hostServices.showDocument(FACCEBOOK_URL);
  }

  @FXML
  public void onGithub() {
    SplashScreen.hostServices.showDocument(GITHUB_URL);
  }

  @FXML
  public void onEmail() {
    SplashScreen.hostServices.showDocument(EMAIL_URL);
  }

  @FXML
  public void onLinkedin() {
    SplashScreen.hostServices.showDocument(LINKEDIN_URL);
  }

  public void onOk() {
    stage.close();
  }

}
