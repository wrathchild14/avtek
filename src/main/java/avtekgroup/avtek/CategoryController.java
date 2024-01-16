package avtekgroup.avtek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class CategoryController {

    @FXML
    private Label warningLabel;

    @FXML
    private void confirmSelection(ActionEvent event) {
    }

    @FXML
    private void handleCategoryClick(ActionEvent event) {
        Button selectedCategory = (Button) event.getSource();
        String category = selectedCategory.getText();

        System.out.println("Selected Car Category: " + category);

        if (category.equals("Compact")) {
            warningLabel.setText("Compact cars may have limited trunk space.");
            warningLabel.setVisible(true);
        } else {
            warningLabel.setVisible(false);
        }
    }
}
