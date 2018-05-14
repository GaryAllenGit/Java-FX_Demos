package demo1;

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

public class PopUp2 extends PopupWindow{

    // This pop up window is non-modal

    public PopUp2(Application parent) {
        final Stage dialog = new Stage();

        dialog.initModality(Modality.NONE);

        VBox dialogVbox = new VBox(20);
        dialogVbox.setAlignment(Pos.CENTER);

        Text label = new Text("This is a Non-Modal Dialog");

        Button btn = new Button("Done");
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
