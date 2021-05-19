package tiktak;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Button btn00, btn10, btn20,
                    btn01, btn11, btn21,
                    btn02, btn12, btn22;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //new gridPane, ez pontosan mi is?
        GridPane gridPane = new GridPane();

        //ablak mérete
        gridPane.setMinHeight(300);
        gridPane.setMinWidth(300);

        //elhelyezés
        gridPane.setAlignment(Pos.CENTER);
        //vízszintes és függőleges helyek az elemek között
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //az ablak szélétől befele lévő hely /rés
        gridPane.setPadding(new Insets(10,10,10,10));

        //új ablak (i guess)
        Scene scene = new Scene(gridPane);

        //ablak címe
        primaryStage.setTitle("Thicc-tank");
        primaryStage.setScene(scene);
        //megjelenítés
        primaryStage.show();

        //create new elements
        create3x3Buttons();


        //add 3x3 elements
        add3x3Buttons(gridPane);


        //add new element to scene
    }

    public void create3x3Buttons() {
        btn00 = new Button();
        btn10 = new Button();
        btn20 = new Button();
        btn01 = new Button();
        btn11 = new Button();
        btn21 = new Button();
        btn02 = new Button();
        btn12 = new Button();
        btn22 = new Button();
    }

    public void add3x3Buttons(GridPane gridPane) {
        gridPane.add(btn00, 0,0);
        gridPane.add(btn10, 1,0);
        gridPane.add(btn20, 2,0);

        gridPane.add(btn01, 0,1);
        gridPane.add(btn11, 1,1);
        gridPane.add(btn21, 2,1);

        gridPane.add(btn02, 0,2);
        gridPane.add(btn12, 1,2);
        gridPane.add(btn22, 2,2);
    }

    public static void main(String[] args) {

        launch(args);
    }
}
