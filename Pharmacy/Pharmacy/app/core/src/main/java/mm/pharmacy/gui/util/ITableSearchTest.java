package mm.pharmacy.gui.util;

import javafx.scene.control.TreeItem;

public interface ITableSearchTest<T> {

  boolean onTest(TreeItem<T> employeeProp, String value);
}
