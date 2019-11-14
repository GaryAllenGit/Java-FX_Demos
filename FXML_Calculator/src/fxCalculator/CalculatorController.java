package fxCalculator;

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

    public void addNumbers() {
        try {
            double d1 = Double.parseDouble(input1TF.getText());
            double d2 = Double.parseDouble(input2TF.getText());

            double result = d1 + d2;

            resultTF.setText("" + result);
        } catch (NumberFormatException e) {
            resultTF.setText("Error!");
        }
    }

    public void subNumbers() {
        try {
            double d1 = Double.parseDouble(input1TF.getText());
            double d2 = Double.parseDouble(input2TF.getText());

            double result = d1 - d2;

            resultTF.setText("" + result);
        } catch (NumberFormatException e) {
            resultTF.setText("Error!");
        }
    }

    public void multNumbers() {
        try {
            double d1 = Double.parseDouble(input1TF.getText());
            double d2 = Double.parseDouble(input2TF.getText());

            double result = d1 * d2;

            resultTF.setText("" + result);
        } catch (NumberFormatException e) {
            resultTF.setText("Error!");
        }
    }

    public void divNumbers() {
        try {
            double d1 = Double.parseDouble(input1TF.getText());
            double d2 = Double.parseDouble(input2TF.getText());

            double result = d1 / d2;

            resultTF.setText("" + result);
        } catch (NumberFormatException e) {
            resultTF.setText("Error!");
        }
    }
}
