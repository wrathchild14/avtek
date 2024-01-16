package avtekgroup.avtek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class TimeViewController {
    @FXML
    public ComboBox<Label> pickupLocationComboBox;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<Label> durationComboBox;

    @FXML
    private Label warningLabel;

    @FXML
    private void initialize() {
        datePicker.setValue(LocalDate.now());
    }

    @FXML
    private void confirmSelection(ActionEvent event) throws IOException {
        String selectedDate = datePicker.getValue() != null ? datePicker.getValue().toString() : null;
        Label selectedLabel = durationComboBox.getValue();

        if (selectedDate != null && selectedLabel != null) {
            String selectedDuration = selectedLabel.getText();
            System.out.println("Selected Date: " + selectedDate);
            System.out.println("Selected Duration: " + selectedDuration);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("category.fxml"));
            Stage currentStage = (Stage) datePicker.getScene().getWindow();
            currentStage.setScene(new Scene(fxmlLoader.load(), 1280, 720));
        } else {
            System.out.println("Please select both date and duration.");
            warningLabel.setVisible(true);
        }
    }
}
