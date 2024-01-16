package avtekgroup.avtek;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
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
    public Label warningLabel;
    public CheckBox insuranceCheckBox;
    public Label priceLabel;
    public Label ageWarning;

    public void proceedToPayment(ActionEvent actionEvent) throws IOException {
        if (areAllFieldsFilled()) {
            if (Integer.parseInt(ageField.getText()) >= 18) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("payment.fxml"));
                Parent paymentParent = fxmlLoader.load();

                Stage paymentStage = new Stage();
                paymentStage.setTitle("Payment");
                paymentStage.setScene(new Scene(paymentParent, 400, 300));

                // blocks interactions with the primary stage)
                paymentStage.initModality(Modality.APPLICATION_MODAL);

                paymentStage.show();
            } else {
                ageWarning.setVisible(true);
            }
        } else {
            warningLabel.setVisible(true);
        }
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

    private boolean areAllFieldsFilled() {
        return !nameField.getText().isEmpty() &&
                !addressField.getText().isEmpty() &&
                !emailField.getText().isEmpty() &&
                !phoneField.getText().isEmpty() &&
                !ageField.getText().isEmpty() &&
                !licenseValidityField.getText().isEmpty() &&
                ageField.getText().matches("\\d+") &&
                licenseValidityField.getText().matches("\\d+");
    }

    public void updatePrice(ActionEvent actionEvent) {
        double basePrice = 1200.0;
        double insurancePrice = 2.0;
        double totalPrice = basePrice + (insuranceCheckBox.isSelected() ? insurancePrice : 0);
        priceLabel.setText("Price: " + totalPrice + " Eur");
    }
}
