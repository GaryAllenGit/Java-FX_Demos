package fxMenuDemo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class ExampleDialog extends Stage {
    // A class to demonstrate both custom dialogs and a range of JavaFX components

    private ComboBox<String> selectionCombo;
    private CheckBox showResultsCheckBox;
    private TextField resultTextField;

    ExampleDialog(){
        // initialise all the components
        HBox makeSelectionBox = new HBox();
        makeSelectionBox.setSpacing(25);
        makeSelectionBox.setPadding(new Insets(10));
        makeSelectionBox.setAlignment(Pos.CENTER);

        HBox showSelectionBox = new HBox();
        showSelectionBox.setSpacing(25);
        showSelectionBox.setPadding(new Insets(15));

        HBox buttonsBox = new HBox();
        buttonsBox.setSpacing(30);
        buttonsBox.setPadding(new Insets(10));
        buttonsBox.setAlignment(Pos.CENTER);

        Label selectionLabel = new Label("Select Item");

        selectionCombo = new ComboBox<>();
        selectionCombo.getItems().addAll("Apples", "Pears", "Plums", "Grapes");

        showResultsCheckBox = new CheckBox("Show Selections");
        showResultsCheckBox.setSelected(true);

        resultTextField = new TextField("No Selection Made");

        Button okButton = new Button("OK");

        Button cancelButton = new Button("Cancel");


        // add action listeners to the combo box and buttons
        selectionCombo.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                doSelectionUpdate();
            }
        });

        okButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                ExampleDialog.this.close();
            }
        });

        cancelButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                ExampleDialog.this.close();
            }
        });


        // add the components to the HBoxes
        makeSelectionBox.getChildren().addAll(selectionLabel, selectionCombo);
        showSelectionBox.getChildren().addAll(showResultsCheckBox, resultTextField);
        buttonsBox.getChildren().addAll(okButton, cancelButton);

        //stack the HBoxes in a VBox
        VBox dialogBox = new VBox(makeSelectionBox, showSelectionBox, buttonsBox);

        // add the VBox to a scene, then add the scene to the stage
        Scene dialogScene = new Scene(dialogBox, 375, 150);

        this.setScene(dialogScene);
    }

    private void doSelectionUpdate() {
        if (showResultsCheckBox.isSelected()){
            resultTextField.setText("Selected Fruit is " + selectionCombo.getValue());
        }
    }
}
