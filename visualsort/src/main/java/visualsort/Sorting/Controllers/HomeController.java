package visualsort.Sorting.Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import visualsort.App;

public class HomeController {

    @FXML private Button goToRandom;
    @FXML private Button goToCustom;

    public static String where;
    

    @FXML void switchToCustom(ActionEvent event) throws IOException {
        where = "custom";
        App.setRoot("Newest");
    }

    @FXML void switchToRandom(ActionEvent event) throws IOException {
        where = "random";
        App.setRoot("Newest");
    }
}
