import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CSS_Switching_Demo extends Application {

    // Load the css files
    private final String theme1Url = getClass().getResource("theme1.css").toExternalForm();
    private final String theme2Url = getClass().getResource("theme2.css").toExternalForm();

    @Override
    public void start(Stage primaryStage) {
        // Create the main GUI
        VBox fullGUI = new VBox();
        fullGUI.setAlignment(Pos.CENTER);
        fullGUI.setSpacing(10);

        // Create the main Scene
        Scene scene = new Scene(fullGUI, 300, 250);

        // Create three buttons to control the themes
        final Button button1 = new Button("No Theme (Default)");
        button1.getStyleClass().add("buttonStyle");
        button1.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                scene.getStylesheets().removeAll(theme1Url, theme2Url);
            }
        });

        final Button button2 = new Button("Load Theme 1");
        button2.getStyleClass().add("buttonStyle");
        button2.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                scene.getStylesheets().remove(theme2Url);
                if (!scene.getStylesheets().contains(theme1Url)) {
                    scene.getStylesheets().add(theme1Url);
                }
            }
        });

        final Button button3 = new Button("Load Theme 2");
        button3.getStyleClass().add("buttonStyle");
        button3.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                scene.getStylesheets().remove(theme1Url);
                if (!scene.getStylesheets().contains(theme2Url)) {
                    scene.getStylesheets().add(theme2Url);
                }
            }
        });

        // Add another component just for demo purposes.  This is a ComboBox.
        ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList(
                "Just", "another", "control", "for", "demo", "purposes."));

        fullGUI.getChildren().addAll(button1, button2, button3, comboBox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

