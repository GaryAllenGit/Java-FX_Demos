import javafx.application.Application;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ActiveInterfaceDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // declare the border layout for the window
        BorderPane borderPane = new BorderPane();

        // declare the top HBox and the buttons to go in it.
        HBox topBox = new HBox();
        topBox.setAlignment(Pos.CENTER);
        topBox.setPadding(new Insets(10, 10, 10, 10));
        topBox.setSpacing(20);

        Button button1 = new Button("Press Me");
        button1.setPrefSize(80,25);

        Button button2 = new Button("Now Me");
        button2.setPrefSize(80,25);
        button2.setDisable(true);

        Button button3 = new Button("Me Last");
        button3.setPrefSize(80,25);
        button3.setDisable(true);

        topBox.getChildren().addAll(button1, button2, button3);


        // declare the middle HBox and the combo box and button to go in it.
        HBox middleBox = new HBox();
        middleBox.setAlignment(Pos.CENTER);
        middleBox.setPadding(new Insets(10, 10, 10, 10));
        middleBox.setSpacing(20);

        ComboBox<String> combo = new ComboBox<String>();
        combo.setPromptText("Pick One...");
        combo.getItems().addAll("Start Again", "Go To End");
        combo.setVisible(false);

        Button button4 = new Button("Click to Select");
        button4.setPrefSize(150,25);
        button4.setVisible(false);

        middleBox.getChildren().addAll(combo, button4);


        // declare the lower HBox and the button to go in it.
        HBox bottomBox = new HBox();
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(10, 10, 10, 10));
        bottomBox.setSpacing(20);

        Button doneButton = new Button("Finished");
        doneButton.setPrefSize(80,25);
        doneButton.setVisible(false);

        bottomBox.getChildren().add(doneButton);


        // add the action listeners to the buttons and the combo box
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button1.setDisable(true);
                button2.setDisable(false);
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button2.setDisable(true);
                button3.setDisable(false);
            }
        });

        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button3.setDisable(true);
                combo.setVisible(true);
                button4.setVisible(true);
            }
        });

        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String selectedString = combo.getValue();
                if (selectedString.equals("Start Again")){
                    button1.setDisable(false);
                    combo.setValue(null);
                    combo.setVisible(false);
                    button4.setVisible(false);
                } else {
                    combo.setDisable(true);
                    button4.setDisable(true);
                    doneButton.setVisible(true);
                }
            }
        });

        doneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });



        // add the boxes to the border layout
        borderPane.setTop(topBox);
        borderPane.setCenter(middleBox);
        borderPane.setBottom(bottomBox);

        // add the border layout to a scene and set this on the primary stage
        Scene scene = new Scene(borderPane, 320, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
