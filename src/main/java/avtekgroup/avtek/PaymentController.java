package avtekgroup.avtek;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentController {
    public PasswordField creditCardField;
    public PasswordField ccvField;
    public Button payButton;
    public Label warningLabel;
    public Button payCash;
    public Label complete;

    public void pay(ActionEvent actionEvent) throws IOException {
        if (isCreditCardValid(creditCardField.getText()) && isCCVValid(ccvField.getText())) {
            complete.setVisible(true);
//            Stage paymentStage = (Stage) payButton.getScene().getWindow();
//            paymentStage.close();

            FXMLLoader detailsLoader = new FXMLLoader(getClass().getResource("details.fxml"));
            Parent detailsParent = detailsLoader.load();
            DetailsController detailsController = detailsLoader.getController();
            detailsController.completePayment();
        } else {
            warningLabel.setVisible(true);
        }
    }

    private boolean isCreditCardValid(String creditCard) {
        return creditCard != null && creditCard.trim().length() == 16 && creditCard.matches("\\d+");
    }

    private boolean isCCVValid(String ccv) {
        return ccv != null && ccv.trim().length() == 3 && ccv.matches("\\d+");
    }

    public void payWithCash(ActionEvent actionEvent) throws IOException {
//        Stage paymentStage = (Stage) payButton.getScene().getWindow();
//        paymentStage.close();
        complete.setVisible(true);

        FXMLLoader detailsLoader = new FXMLLoader(getClass().getResource("details.fxml"));
        Parent detailsParent = detailsLoader.load();
        DetailsController detailsController = detailsLoader.getController();
        detailsController.completePayment();
    }
}
