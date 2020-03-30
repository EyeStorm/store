package mm.pharmacy.screen.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import mm.pharmacy.ApplicationBoot;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author <a href="mailto:rene.gielen@gmail.com">Rene Gielen</a>
 * @noinspection RedundantThrows
 */
public class SplashBoot extends Application {

  private ConfigurableApplicationContext context;

  @Override
  public void init() throws Exception {
    this.context = new SpringApplicationBuilder()
      .sources(ApplicationBoot.class)
      .run(getParameters().getRaw().toArray(new String[0]));
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    context.publishEvent(new StageReadyEvent(primaryStage));
  }

  @Override
  public void stop() throws Exception {
    context.close();
    Platform.exit();
  }
}
