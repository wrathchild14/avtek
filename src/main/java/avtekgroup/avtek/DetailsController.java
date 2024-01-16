package avtekgroup.avtek;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DetailsController {
    public TextField nameField;
    public TextField addressField;
    public TextField emailField;
    public TextField phoneField;
    public TextField ageField;
    public TextField licenseValidityField;
    public Label paymentCompleteLabel;

    public void proceedToPayment(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("payment.fxml"));
        Parent paymentParent = fxmlLoader.load();

        Stage paymentStage = new Stage();
        paymentStage.setTitle("Payment");
        paymentStage.setScene(new Scene(paymentParent, 400, 300));

        // blocks interactions with the primary stage)
        paymentStage.initModality(Modality.APPLICATION_MODAL);

        paymentStage.show();
    }

    public void completePayment() {
        System.out.println("Payment complete");
        paymentCompleteLabel.setVisible(true);
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("transmission.fxml"));
        Stage currentStage = (Stage) nameField.getScene().getWindow();
        currentStage.setScene(new Scene(fxmlLoader.load(), 800, 500));
    }
}
