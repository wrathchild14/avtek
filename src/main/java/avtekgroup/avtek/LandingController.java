package avtekgroup.avtek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LandingController {
    @FXML
    private Label welcomeText;

    @FXML
    private void onButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("car-choice.fxml"));
        Stage currentStage = (Stage) welcomeText.getScene().getWindow();
        currentStage.setScene(new Scene(fxmlLoader.load(), 1280, 720));
    }
}