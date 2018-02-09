package fxCalculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    public TextField input1TF;
    public TextField input2TF;
    public TextField resultTF;
    public Button addButton;
    public Button subButton;
    public Button multButton;
    public Button divButton;

    public void addNumbers(ActionEvent actionEvent) {
        try {
            double d1 = new Double(input1TF.getText());
            double d2 = new Double(input2TF.getText());

            double result = d1 + d2;

            resultTF.setText("" + result);
        } catch (NumberFormatException e) {
            resultTF.setText("Error!");
        }
    }

    public void subNumbers(ActionEvent actionEvent) {
        try {
            double d1 = new Double(input1TF.getText());
            double d2 = new Double(input2TF.getText());

            double result = d1 - d2;

            resultTF.setText("" + result);
        } catch (NumberFormatException e) {
            resultTF.setText("Error!");
        }
    }

    public void multNumbers(ActionEvent actionEvent) {
        try {
            double d1 = new Double(input1TF.getText());
            double d2 = new Double(input2TF.getText());

            double result = d1 * d2;

            resultTF.setText("" + result);
        } catch (NumberFormatException e) {
            resultTF.setText("Error!");
        }
    }

    public void divNumbers(ActionEvent actionEvent) {
        try {
            double d1 = new Double(input1TF.getText());
            double d2 = new Double(input2TF.getText());

            double result = d1 / d2;

            resultTF.setText("" + result);
        } catch (NumberFormatException e) {
            resultTF.setText("Error!");
        }
    }
}
