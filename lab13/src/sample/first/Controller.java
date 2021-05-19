package sample.first;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    private int pressCount = 0;
    @FXML
    private Button firstButton;

    public void buttonPressed(ActionEvent actionEvent) {
        pressCount++;
        //System.out.println("Button pressed " + pressCount + " times");
        firstButton.setText("Pressed " + pressCount);
    }
}
