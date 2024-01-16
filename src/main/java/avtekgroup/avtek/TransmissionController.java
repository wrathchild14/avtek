package avtekgroup.avtek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class TransmissionController {

    @FXML
    private ComboBox<Label> engineTypeComboBox;

    @FXML
    private ComboBox<Label> transmissionComboBox;

    @FXML
    private void confirmSelection(ActionEvent event) throws IOException {
        String selectedEngineType = engineTypeComboBox.getValue().getText();
        String selectedTransmission = transmissionComboBox.getValue().getText();

        if (selectedEngineType != null && selectedTransmission != null) {
            System.out.println("Selected Engine Type: " + selectedEngineType);
            System.out.println("Selected Transmission: " + selectedTransmission);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("details.fxml"));
            Stage currentStage = (Stage) engineTypeComboBox.getScene().getWindow();
            currentStage.setScene(new Scene(fxmlLoader.load(), 1280, 720));
        } else {
            System.out.println("Please select both engine type and transmission.");
        }
    }
}
