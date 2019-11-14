package fxCountingButton;

import javafx.scene.control.Button;

public class CountController {
    public Button countingButton;

    public void incrementCountOnButton() {
        int i = Integer.parseInt(countingButton.getText());
        countingButton.setText("" + (i + 1));
    }
}
