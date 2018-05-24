package fx_Lists_and_ListModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class FXListDemo implements Initializable{
    @FXML
    public Button removeButton;
    public Button addButton;
    public TextField newItemTF;
    public ListView<String> itemsList;

    private ObservableList<String> listOfItems;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listOfItems = FXCollections.observableArrayList();
        listOfItems.add("Test Value 1");
        listOfItems.add("Test Value 2");
        listOfItems.add("Test Value 3");

        itemsList.setItems(listOfItems);
    }

    public void removeItem(ActionEvent actionEvent) {
        int i = itemsList.getSelectionModel().getSelectedIndex();
        if (i != -1) {
            listOfItems.remove(i);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "No Item Selected", ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void addItem(ActionEvent actionEvent) {
        String s = newItemTF.getText();
        if (!s.equals("")) {
            listOfItems.add(s);
            newItemTF.setText("");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "No Value Entered", ButtonType.OK);
            alert.showAndWait();
        }
    }
}
