import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Calculator");

        // declare a border pane
        BorderPane borderPane = new BorderPane();

        // declare some HBoxes (horizontal boxes)
        HBox topHBox = new HBox();
        topHBox.setAlignment(Pos.CENTER);
        topHBox.setPadding(new Insets(10, 10, 10, 10));
        topHBox.setSpacing(20);

        HBox middleHBox = new HBox();
        middleHBox.setAlignment(Pos.CENTER);
        middleHBox.setPadding(new Insets(10, 10, 10, 10));
        middleHBox.setSpacing(20);

        HBox bottomHBox = new HBox();
        bottomHBox.setAlignment(Pos.CENTER);
        bottomHBox.setPadding(new Insets(10, 10, 10, 10));
        bottomHBox.setSpacing(20);

        //declare all the controls (text fields and buttons)
        TextField input1TF = new TextField();
        input1TF.setAlignment(Pos.CENTER_RIGHT);

        TextField input2TF = new TextField();
        input2TF.setAlignment(Pos.CENTER_RIGHT);

        TextField resultTF = new TextField();
        resultTF.setAlignment(Pos.CENTER_RIGHT);
        resultTF.setEditable(false);

        Button addButton = new Button("+");
        addButton.setPrefSize(30,30);

        Button subButton = new Button("-");
        subButton.setPrefSize(30,30);

        Button multButton = new Button("X");
        multButton.setPrefSize(30,30);

        Button divButton = new Button("/");
        divButton.setPrefSize(30,30);


        // add listeners to the buttons
        addButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                addNumbers(input1TF, input2TF, resultTF);
            }
        });

        subButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                subtractNumbers(input1TF, input2TF, resultTF);
            }
        });

        multButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                multiplyNumbers(input1TF, input2TF, resultTF);
            }
        });

        divButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                divideNumbers(input1TF, input2TF, resultTF);
            }
        });

        // add the controls to the boxes
        topHBox.getChildren().addAll(input1TF, input2TF);
        middleHBox.getChildren().addAll(addButton, subButton, multButton, divButton);
        bottomHBox.getChildren().add(resultTF);

        // add the boxes to the border layout
        borderPane.setTop(topHBox);
        borderPane.setCenter(middleHBox);
        borderPane.setBottom(bottomHBox);

        // add the border layout to a scene and set this on the primary stage
        Scene scene = new Scene(borderPane, 350, 150);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void addNumbers(TextField input1TF, TextField input2TF, TextField resultTF) {
        try {
            double d1 = Double.parseDouble(input1TF.getText());
            double d2 = Double.parseDouble(input2TF.getText());

            double result = d1 + d2;

            resultTF.setText("" + result);
        } catch (NumberFormatException e) {
            resultTF.setText("Not a Number");
        }
    }

    private void subtractNumbers(TextField input1TF, TextField input2TF, TextField resultTF) {
        try {
            double d1 = Double.parseDouble(input1TF.getText());
            double d2 = Double.parseDouble(input2TF.getText());

            double result = d1 - d2;

            resultTF.setText("" + result);
        } catch (NumberFormatException e) {
            resultTF.setText("Not a Number");
        }
    }

    private void multiplyNumbers(TextField input1TF, TextField input2TF, TextField resultTF) {
        try {
            double d1 = Double.parseDouble(input1TF.getText());
            double d2 = Double.parseDouble(input2TF.getText());

            double result = d1 * d2;

            resultTF.setText("" + result);
        } catch (NumberFormatException e) {
            resultTF.setText("Not a Number");
        }
    }

    private void divideNumbers(TextField input1TF, TextField input2TF, TextField resultTF) {
        try {
            double d1 = Double.parseDouble(input1TF.getText());
            double d2 = Double.parseDouble(input2TF.getText());

            double result = d1 / d2;

            resultTF.setText("" + result);
        } catch (NumberFormatException e) {
            resultTF.setText("Not a Number");
        }
    }
}
