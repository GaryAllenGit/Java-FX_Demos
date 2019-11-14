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

class PopUp2 extends Stage{

    // This pop up window is non-modal

    PopUp2() {

        this.initModality(Modality.NONE);

        VBox dialogVbox = new VBox(20);
        dialogVbox.setAlignment(Pos.CENTER);

        Text label = new Text("This is a Non-Modal Dialog");

        Button btn = new Button("Done");
        btn.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                PopUp2.this.close();
            }
        });

        dialogVbox.getChildren().add(label);
        dialogVbox.getChildren().add(btn);

        Scene dialogScene = new Scene(dialogVbox, 200, 100);
        this.setScene(dialogScene);
    }
}
