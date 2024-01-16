package avtekgroup.avtek;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentController {
    public PasswordField creditCardField;
    public PasswordField ccvField;
    public Button payButton;

    public void pay(ActionEvent actionEvent) throws IOException {
        Stage paymentStage = (Stage) payButton.getScene().getWindow();
        paymentStage.close();

        FXMLLoader detailsLoader = new FXMLLoader(getClass().getResource("details.fxml"));
        Parent detailsParent = detailsLoader.load();
        DetailsController detailsController = detailsLoader.getController();
        detailsController.completePayment();
    }
}
