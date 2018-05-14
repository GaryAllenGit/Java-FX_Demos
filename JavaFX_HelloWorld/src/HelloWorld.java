import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    private Label helloLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");

        Button helloButton = new Button();
        helloButton.setText("Say 'Hello World'");
        helloButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // System.out.println("Hello World!");
                helloLabel.setText("Hello World!");
            }
        });

        helloLabel = new Label("Speak to me!");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(helloButton,0,0);
        grid.add(helloLabel, 0,2);

        Scene scene = new Scene(grid, 220, 175);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}