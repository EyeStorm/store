package mm.pharmacy.screen.application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import mm.pharmacy.screen.controller.MainWindow;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:rene.gielen@gmail.com">Rene Gielen</a>
 */
@Component
public class PrimaryStageInitializer implements ApplicationListener<StageReadyEvent> {

  private final FxWeaver fxWeaver;

  @Autowired
  public PrimaryStageInitializer(FxWeaver fxWeaver) {
    this.fxWeaver = fxWeaver;
  }

  @Override
  public void onApplicationEvent(StageReadyEvent event) {
    Stage stage = event.stage;
    Scene scene = new Scene(fxWeaver.loadView(MainWindow.class), 400, 300);
    stage.setScene(scene);
    stage.show();
  }
}
