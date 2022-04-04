package visualsort;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

    @FXML private Button goToRandom;
    @FXML private Button goToCustom;

    public static double dividerPosition;
    

    @FXML void switchToCustom(ActionEvent event) throws IOException {
        dividerPosition = 100;
        App.setRoot("Picker");
    }

    @FXML void switchToRandom(ActionEvent event) throws IOException {
        dividerPosition = 0;
        App.setRoot("Picker");
    }
}
