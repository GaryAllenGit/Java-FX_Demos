package fxCountingButton;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class CountController {
    public Button countingButton;

    public void incrementCountOnButton(ActionEvent actionEvent) {
        int i = new Integer(countingButton.getText());
        countingButton.setText("" + (i + 1));
    }
}
