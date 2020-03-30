package com.tiagohs.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class BeanUtils implements ApplicationContextAware {
  public static ApplicationContext context;

  public static <T> T getBean(Class<T> beanClass) {
    return context.getBean(beanClass);
  }

  public static <T> T getBean(Class<T> beanClass, Object... args) {
    return context.getBean(beanClass, args);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    context = applicationContext;
  }
}
