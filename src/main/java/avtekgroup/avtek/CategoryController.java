package avtekgroup.avtek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CategoryController {

    @FXML
    private Label warningLabel;

    @FXML
    private Button confirmButton;

    private String selectedCategory;

    @FXML
    private void confirmSelection(ActionEvent event) throws IOException {
        if (selectedCategory != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("car-choice.fxml"));
            Stage currentStage = (Stage) warningLabel.getScene().getWindow();
            currentStage.setScene(new Scene(fxmlLoader.load(), 800, 500));
        } else {
            warningLabel.setText("Please select a car category.");
            warningLabel.setVisible(true);
        }
    }

    @FXML
    private void handleCategoryClick(ActionEvent event) {
        Button clickedCategory = (Button) event.getSource();
        selectedCategory = clickedCategory.getText();

        System.out.println("Selected Car Category: " + selectedCategory);

        if (selectedCategory.equals("Compact")) {
            warningLabel.setText("Compact cars may have limited trunk space.");
            warningLabel.setVisible(true);
        } else {
            warningLabel.setVisible(false);
        }

        confirmButton.setDisable(false);
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("time-view.fxml"));
        Stage currentStage = (Stage) warningLabel.getScene().getWindow();
        currentStage.setScene(new Scene(fxmlLoader.load(), 800, 500));
    }
}
