package mm.pharmacy;

import mm.pharmacy.models.LoginModel;
import mm.pharmacy.services.api.IUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
public class ProjectModuleScreenApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(ProjectModuleScreenApplication.class, args);
    IUserService userService = ctx.getBean("userService", IUserService.class);
    LoginModel loginModel = new LoginModel();
    loginModel.setPassword("dbase123");
    loginModel.setUserName("bharat0126");
    System.out.println(userService.getUser(loginModel).toString());

    System.out.println("----------------------------------------------");
    System.out.println(userService.findAll());
  }
}
