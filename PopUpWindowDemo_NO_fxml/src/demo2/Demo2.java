package demo2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Optional;

public class Demo2 extends Application {

    private String textValue = "No value entered";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button1 = new Button();
        button1.setText("Enter A String");
        button1.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        TextInputDialog dialog = new TextInputDialog("Enter a value");

                        dialog.setTitle("Get Text Input");
                        dialog.setHeaderText("Enter some text");
                        dialog.setContentText("Text:");

                        Optional<String> inputValue = dialog.showAndWait();

                        textValue = inputValue.orElse("undefined");
                    }
                });

        Button button2 = new Button();
        button2.setText("Display the String");
        button2.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ShowTextPopUp popup = new ShowTextPopUp(Demo2.this, textValue);
                        popup.show(primaryStage);
                    }
                });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(button1,0,0);
        grid.add(button2,1,0);


        Scene scene = new Scene(grid, 350, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pop Up Window Demo 2");
        primaryStage.show();

    }
}
