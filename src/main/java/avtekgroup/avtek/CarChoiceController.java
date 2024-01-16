package avtekgroup.avtek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class CarChoiceController {
    @FXML
    private Label selectedCarLabel;

    @FXML
    private ImageView carImageView;

    @FXML
    private void carSelected(ActionEvent event) {
        Button selectedButton = (Button) event.getSource();
        String carModel = selectedButton.getText();
        String selectedCar = selectedButton.getText();

        selectedCarLabel.setText("Selected Car: " + selectedCar);
        selectedCarLabel.setVisible(true);

        String imagePath = getCarImagePath(carModel);
        Image image = loadImage(imagePath);
        carImageView.setImage(image);
        carImageView.setVisible(true);
    }

    private String getCarImagePath(String carModel) {
        return switch (carModel) {
            case "MB C180" -> "images/mb_c180.jpeg";
            case "Audi A5" -> "images/audi_a5.jpg";
            default -> "";
        };
    }

    private Image loadImage(String imagePath) {
        try {
            return new Image(new FileInputStream(imagePath));
        } catch (IOException e) {
            return null;
        }
    }

    @FXML
    public void confirmAndProceed(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("transmission.fxml"));
        Stage currentStage = (Stage) selectedCarLabel.getScene().getWindow();
        currentStage.setScene(new Scene(fxmlLoader.load(), 800, 500));
    }
}
