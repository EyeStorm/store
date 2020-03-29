package com.tiagohs.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

@Component
@Data
@AllArgsConstructor
public class I18N {

  public static Locale PORTUGUESE_BRAZILLIAN = new Locale("pt", "BR");
  public static Locale ENGLISH = new Locale("en", "US");

  private static Locale customLocale;
  private ResourceBundle bundle;

  public I18N() {
    this.updateResourceBundle(updateLocale(PORTUGUESE_BRAZILLIAN));
  }

  public Locale updateLocale(Locale locale) {
    this.updateResourceBundle(locale);
    customLocale = locale;
    return customLocale;
  }

  public Locale updateLocale(String language, String country) {
    return updateLocale(new Locale(language, country));
  }

  public ResourceBundle updateResourceBundle(ResourceBundle bundle) {
    this.bundle = bundle;

    return bundle;
  }

  public ResourceBundle updateResourceBundle(Locale locale) {
    return this.updateResourceBundle(ResourceBundle.getBundle("i18n/i18n", locale));
  }

  public String getString(String key) {
    return bundle.getString(key);
  }
}
