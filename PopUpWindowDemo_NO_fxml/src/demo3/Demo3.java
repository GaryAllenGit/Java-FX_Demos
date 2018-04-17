package demo3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Demo3 extends Application {

    private Employee emp;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button1 = new Button();
        button1.setText("Enter Details");
        button1.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        EnterDetailsPopUp popup = new EnterDetailsPopUp(Demo3.this);
                        popup.show(primaryStage);
                    }
                });

        Button button2 = new Button();
        button2.setText("Display Details");
        button2.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Alert showOutputAlert = new Alert(Alert.AlertType.INFORMATION,
                                "Employee = "+ emp, ButtonType.OK);
                        showOutputAlert.showAndWait();
                    }
                });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(button1,0,0);
        grid.add(button2,1,0);


        Scene scene = new Scene(grid, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pop Up Window Demo 3");
        primaryStage.show();

    }

    void setEmployee(String id, String fn, String sn, String dept) {
		emp = new Employee(id, fn, sn, dept);
	}
}
