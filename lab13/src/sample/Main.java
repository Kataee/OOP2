package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main extends Application {

    private Text firstName, lastName, email;
    private TextField firstNameField, lastNameField, emailField;
    private Button submitButton, clearButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("first/sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//         primaryStage.show();

        GridPane gridPane = new GridPane();
        gridPane.setMinHeight(300);
        gridPane.setMinWidth(300);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        gridPane.setPadding(new Insets(10, 10, 10, 10));


        Scene scene = new Scene(gridPane);

        primaryStage.setTitle("Data App");
        primaryStage.setScene(scene);
        primaryStage.show();

         firstName = new Text("Firstname: ");
         lastName = new Text("Lastname: ");
         email = new Text("Email: ");
         submitButton = new Button("Submit");
         clearButton = new Button("Clear");


         firstNameField = new TextField();
         lastNameField = new TextField();
         emailField = new TextField();

         submitButton = new Button("Submit");
         clearButton = new Button("Clear");

        clearButton.setOnAction(actionEvent -> clearAllFields());
        submitButton.setOnAction(actionEvent -> {
            saveDataToFile("registration.csv");
            clearAllFields();
        });


        gridPane.add(firstName, 0, 0);
        gridPane.add(firstNameField, 1, 0);
        gridPane.add(lastName, 0, 1);
        gridPane.add(lastNameField, 1, 1);
        gridPane.add(email, 0, 2);
        gridPane.add(emailField, 1, 2);
        gridPane.add(submitButton, 0, 3);
        gridPane.add(clearButton, 1, 3);


    }

    private void saveDataToFile(String fileName) {
        try (PrintStream output = new PrintStream(fileName)) {
            output.println(firstNameField.getText() + ", " + lastNameField.getText() + ", " + emailField.getText());
            //show alert dialog
            showConfirmationDialog();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    private void showConfirmationDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.show();
    }

    private void clearAllFields() {
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
    }


    public static void main(String[] args) {
        launch(args);
    }

}