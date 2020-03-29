package mm.pharmacy.screen.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;


/**
 * DialogController.
 *
 * @author Rene Gielen
 * @noinspection WeakerAccess
 */
@Component
@FxmlView(prefix = "fxml/dialog")
public class SomeDialog {

  private Stage stage;


  @FXML
  private Button closeButton;
  @FXML
  private VBox dialog;


  @FXML
  public void initialize() {
    // Tạo MenuBar
    MenuBar menuBar = new MenuBar();


    // Tạo các Menu
    Menu fileMenu = new Menu("File");
    Menu editMenu = new Menu("Edit");
    Menu helpMenu = new Menu("Help");

    // Tạo các MenuItem
    MenuItem newItem = new MenuItem("New");
    MenuItem openFileItem = new MenuItem("Open File");
    MenuItem exitItem = new MenuItem("Exit");

    // Sét đặt phím tắt cho MenuItem Exit.
    exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));

    // Thiết lập sự kiện khi người dùng chọn vào Exit.
    exitItem.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        System.exit(0);
      }
    });

    // Add menuItems to the Menus
    // Thêm các MenuItem vào Menu.
    fileMenu.getItems().addAll(newItem, openFileItem, exitItem);

    // Add Menus to the MenuBar
    // Thêm các Menu vào MenuBar
    menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

    dialog.getChildren().add(menuBar);

    this.stage = new Stage();
    stage.setScene(new Scene(dialog));

    closeButton.setOnAction(
      actionEvent -> stage.close()
    );
  }

  public void show() {
    stage.show();
}

}