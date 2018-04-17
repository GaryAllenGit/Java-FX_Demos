package demo2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

public class ShowTextPopUp extends PopupWindow {

    // This pop up window is modal

    public ShowTextPopUp(Application parent, String textToShow) {
        final Stage dialog = new Stage();

        dialog.initModality(Modality.APPLICATION_MODAL);

        VBox dialogVbox = new VBox(20);
        dialogVbox.setAlignment(Pos.CENTER);

        Text label = new Text(textToShow);

        Button btn = new Button("Close");
        btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        dialog.close();
                    }
                });

        dialogVbox.getChildren().add(label);
        dialogVbox.getChildren().add(btn);

        Scene dialogScene = new Scene(dialogVbox, 200, 100);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
