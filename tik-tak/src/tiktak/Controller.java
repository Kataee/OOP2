package tiktak;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.text.TextAlignment;

public class Controller {
    private Button btn;
    @FXML
    public void buttonSet() {
        btn.setAlignment(Pos.CENTER);
        btn.setContentDisplay(ContentDisplay.CENTER);
        btn.setMaxHeight(50);
        btn.setMaxWidth(50);
        btn.setMinHeight(50);
        btn.setMinWidth(50);
        btn.setMnemonicParsing(false);
        btn.setPrefHeight(50);
        btn.setPrefWidth(50);
        btn.setTextAlignment(TextAlignment.CENTER);
        // GridPane.halignment="CENTER"
        // GridPane.valignment="CENTER">


    }
}
