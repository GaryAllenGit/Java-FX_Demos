package fx_Lists_and_ListModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
        int i = itemsList.getEditingIndex();
        if (i != -1) {
            listOfItems.remove(i);
        }
    }

    public void addItem(ActionEvent actionEvent) {
        String s = newItemTF.getText();
        if (!s.equals("")) {
            listOfItems.add(s);
            newItemTF.setText("");
        }
    }
}
