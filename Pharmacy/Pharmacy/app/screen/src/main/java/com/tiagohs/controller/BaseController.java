package com.tiagohs.controller;

import com.tiagohs.SplashScreen;
import com.tiagohs.util.I18N;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public abstract class BaseController {

  @Autowired
  protected I18N i18N;
  protected Stage stage;

  public <T> void init(Stage stage, HashMap<String, T> parameters) {
    this.stage = stage;
    this.stage.setOnHiding(e -> {
      onClose();
    });
    this.stage.setOnHidden(e -> {
      onClose();
    });
  }

  public Stage getStage() {
    return stage;
  }

  public I18N getI18N() {
    return i18N;
  }

  public String getWindowTitle(String titleKey) {
    return SplashScreen.i18n.getString(titleKey);
  }

  protected abstract void onClose();
}
