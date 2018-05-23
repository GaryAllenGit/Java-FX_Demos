package fxMenuDemo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

class ExampleDialog extends PopupWindow {
    // A class to demonstrate both custom dialogs and a range of JavaFX components

    private final Stage thisDialog = new Stage();

    private HBox makeSelectionBox;
    private HBox showSelectionBox;
    private HBox buttonsBox;

    private Label selectionLabel;
    private ComboBox<String> selectionCombo;
    private CheckBox showResultsCheckBox;
    private TextField resultTextField;
    private Button okButton;
    private Button cancelButton;

    public ExampleDialog(){
        // initialise all the components
        makeSelectionBox = new HBox();
        makeSelectionBox.setSpacing(25);
        makeSelectionBox.setPadding(new Insets(10));
        makeSelectionBox.setAlignment(Pos.CENTER);

        showSelectionBox = new HBox();
        showSelectionBox.setSpacing(25);
        showSelectionBox.setPadding(new Insets(15));

        buttonsBox = new HBox();
        buttonsBox.setSpacing(30);
        buttonsBox.setPadding(new Insets(10));
        buttonsBox.setAlignment(Pos.CENTER);

        selectionLabel = new Label("Select Item");

        selectionCombo = new ComboBox<>();
        selectionCombo.getItems().addAll("Apples", "Pears", "Plums", "Grapes");

        showResultsCheckBox = new CheckBox("Show Selections");
        showResultsCheckBox.setSelected(true);

        resultTextField = new TextField("No Selection Made");

        okButton = new Button("OK");

        cancelButton = new Button("Cancel");


        // add action listeners to the combo box and buttons
        selectionCombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                doSelectionUpdate();
            }
        });

        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                thisDialog.close();
            }
        });

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                thisDialog.close();
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
        thisDialog.setScene(dialogScene);
        thisDialog.initModality(Modality.APPLICATION_MODAL);
        thisDialog.show();
    }

    private void doSelectionUpdate() {
        if (showResultsCheckBox.isSelected()){
            resultTextField.setText("Selected Fruit is " + selectionCombo.getValue());
        }
    }
}
