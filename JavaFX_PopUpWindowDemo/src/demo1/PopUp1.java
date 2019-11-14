package demo1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

class PopUp1 extends Stage{

    // This pop up window is modal

    PopUp1() {

        this.initModality(Modality.APPLICATION_MODAL);

        VBox dialogVbox = new VBox(20);
        dialogVbox.setAlignment(Pos.CENTER);

        Text label = new Text("This is a Modal Dialog");

        Button btn = new Button("Close");
        btn.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                PopUp1.this.close();
            }
        });

        dialogVbox.getChildren().add(label);
        dialogVbox.getChildren().add(btn);

        Scene dialogScene = new Scene(dialogVbox, 200, 100);
        this.setScene(dialogScene);
    }
}
