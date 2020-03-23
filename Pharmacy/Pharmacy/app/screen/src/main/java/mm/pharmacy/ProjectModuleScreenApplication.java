package mm.pharmacy;

import javafx.application.Application;
import javafx.scene.Node;
import mm.pharmacy.screen.application.SpringbootJavaFxApplication;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.spring.InjectionPointLazyFxControllerAndViewResolver;
import net.rgielen.fxweaver.spring.SpringFxWeaver;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class ProjectModuleScreenApplication {

  public static void main(String[] args) {
//    ApplicationContext ctx = SpringApplication.run(ProjectModuleScreenApplication.class, args);
//    IUserService userService = ctx.getBean("userService", IUserService.class);
//    LoginModel loginModel = new LoginModel();
//    loginModel.setPassword("dbase123");
//    loginModel.setUserName("bharat0126");
//    System.out.println(userService.getUser(loginModel).toString());
//    System.out.println("----------------------------------------------");
//    System.out.println(userService.findAll());

    Application.launch(SpringbootJavaFxApplication.class, args);
  }

  @Bean
  public FxWeaver fxWeaver(ConfigurableApplicationContext applicationContext) {
    // Would also work with javafx-weaver-core only:
    // return new FxWeaver(applicationContext::getBean, applicationContext::close);
    return new SpringFxWeaver(applicationContext);
  }@Bean

  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public <C, V extends Node> FxControllerAndView<C, V> controllerAndView(FxWeaver fxWeaver,
                                                                         InjectionPoint injectionPoint) {
    return new InjectionPointLazyFxControllerAndViewResolver(fxWeaver)
      .resolve(injectionPoint);
  }
}
