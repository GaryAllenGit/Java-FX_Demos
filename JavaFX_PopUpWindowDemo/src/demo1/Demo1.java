package demo1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Demo1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button1 = new Button();
        button1.setText("Open Pop Up 1");
        button1.setOnAction(
                new EventHandler<>() {
                    @Override
                    public void handle(ActionEvent event) {
                        PopUp1 popup = new PopUp1();
                        popup.initOwner(primaryStage);
                        popup.show();
                    }
                });

        Button button2 = new Button();
        button2.setText("Open Pop Up 2");
        button2.setOnAction(
                new EventHandler<>() {
                    @Override
                    public void handle(ActionEvent event) {
                        PopUp2 popup = new PopUp2();
                        popup.initOwner(primaryStage);
                        popup.show();
                    }
                });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(button1,0,0);
        grid.add(button2,1,0);

        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pop Up Window Demo 1");
        primaryStage.show();

    }
}
