package com.tiagohs;

import com.tiagohs.controller.LoginController;
import com.tiagohs.controller.RootController;
import com.tiagohs.model.Language;
import com.tiagohs.model.User;
import com.tiagohs.service.LanguageService;
import com.tiagohs.service.UserService;
import com.tiagohs.util.BeanUtils;
import com.tiagohs.util.I18N;
import com.tiagohs.util.WindowsUtils;
import javafx.application.HostServices;
import javafx.application.Preloader;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Locale;

public class SplashScreen extends Preloader {

  public static I18N i18n;
  public static ConfigurableApplicationContext springContext;
  public static HostServices hostServices;

  private UserService userService;
  private LanguageService languageService;
  private Stage stage;

  @Override
  public void init() throws Exception {
    SpringApplication.run(MainApplication.class, getParameters().getRaw().toArray(new String[0]));
    userService = BeanUtils.getBean(UserService.class);
    languageService = BeanUtils.getBean(LanguageService.class);
  }

  @Override
  public void start(Stage primaryStage) {
    initI18N();
    userService.finUserSignIn(e -> {
      try {
        User user = (User) e.getSource().getValue();
        if (user == null) {
          WindowsUtils.openNewWindow(primaryStage, LoginController.PATH_FXML, i18n.getString(LoginController.LOGIN_TITLE_KEY), LoginController.PATH_ICON, null);
        } else {
          WindowsUtils.openNewWindow(primaryStage, RootController.PATH_FXML, i18n.getString(RootController.ROOT_TITLE_KEY), RootController.PATH_ICON, null);
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }

    }, null);

  }

  @Override
  public void handleApplicationNotification(PreloaderNotification notification) {
    if (notification instanceof StateChangeNotification) {
      stage.hide();
    }
  }

  private void initI18N() {
    Language languageDefault = languageService.findDefaultLanguage();
    Locale locale = I18N.ENGLISH;
    if (languageDefault != null) {
      locale = new Locale(languageDefault.getLanguageCode(), languageDefault.getCountryCode());
    }
    i18n = BeanUtils.getBean(I18N.class, locale);
    i18n.updateLocale(locale);
  }

}
