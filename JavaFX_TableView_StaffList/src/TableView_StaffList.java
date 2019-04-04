import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
A demo of the use of a TableView used to display Employee data.
This demo allows the data in the table to be edited, sorted, and
for new rows to be added.
 */

public class TableView_StaffList extends Application {

    // The TableView
    private TableView<Employee> staffTable = new TableView<>();

    // The data to be displayed in the TableView
    private final ObservableList<Employee> employeeDate =
            FXCollections.observableArrayList(
                    new Employee("E001", "Gary", "Allen", "CIS"),
                    new Employee("E002", "Hugh", "Osborne", "CIS"),
                    new Employee("E003", "Diane", "Kitchin", "CIS"),
                    new Employee("E004", "Louie", "Quin", "CIS"));

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Set up the GUI

        // A label for the top of the GUI
        final Label label = new Label("Staff List");
        label.setFont(new Font("Arial", 20));

        // The TableView itself
        staffTable.setEditable(true);

        // The columns of the table.  ID is not editable, but the other columns are
        TableColumn<Employee, String> idColumn = new TableColumn<>("ID");
        idColumn.setMinWidth(60);
        idColumn.setCellValueFactory(
            new PropertyValueFactory<>("ID"));
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        idColumn.setEditable(false);

        TableColumn<Employee, String> surnameColumn = new TableColumn<>("Surname");
        surnameColumn.setMinWidth(120);
        surnameColumn.setCellValueFactory(
            new PropertyValueFactory<>("surname"));
        surnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        surnameColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Employee, String> t) {
                        int selectedRow = t.getTablePosition().getRow();
                        Employee selectedEmp = t.getTableView().getItems().get(selectedRow);
                        selectedEmp.setSurname(t.getNewValue());
                    }
                }
        );

        TableColumn<Employee, String> firstnameColumn = new TableColumn<>("First Name");
        firstnameColumn.setMinWidth(120);
        firstnameColumn.setSortable(false);
        firstnameColumn.setCellValueFactory(
            new PropertyValueFactory<>("firstname"));
        firstnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        firstnameColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Employee, String> t) {
                        int selectedRow = t.getTablePosition().getRow();
                        Employee selectedEmp = t.getTableView().getItems().get(selectedRow);
                        selectedEmp.setFirstname(t.getNewValue());
                    }
                }
        );

        TableColumn<Employee, String> departmentColumn = new TableColumn<>("Department");
        departmentColumn.setMinWidth(110);
        departmentColumn.setCellValueFactory(
            new PropertyValueFactory<>("department"));
        departmentColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        departmentColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Employee, String> t) {
                        int selectedRow = t.getTablePosition().getRow();
                        Employee selectedEmp = t.getTableView().getItems().get(selectedRow);
                        selectedEmp.setDepartment(t.getNewValue());
                    }
                }
        );

        staffTable.setItems(employeeDate);
        staffTable.getColumns().addAll(idColumn, surnameColumn, firstnameColumn, departmentColumn);

        // A box to contain the text fields and button to allow new rows to be added
        HBox inputBox = new HBox();

        TextField idTF = new TextField();
        idTF.setPromptText("ID");
        idTF.setMaxWidth(idColumn.getMinWidth());
        TextField surnameTF = new TextField();
        surnameTF.setPromptText("Surname");
        surnameTF.setMaxWidth(surnameColumn.getMinWidth());
        TextField firstnameTF = new TextField();
        firstnameTF.setPromptText("First Name");
        firstnameTF.setMaxWidth(firstnameColumn.getMinWidth());
        TextField departmentTF = new TextField();
        departmentTF.setPromptText("Department");
        departmentTF.setMaxWidth(departmentColumn.getMinWidth());

        Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (idTF.getText().equals("") || surnameTF.getText().equals("")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING,
                            "Enter ID and Surname", ButtonType.OK);
                    alert.showAndWait();
                } else {
                    employeeDate.add(new Employee(
                            idTF.getText(),
                            firstnameTF.getText(),
                            surnameTF.getText(),
                            departmentTF.getText()));
                    idTF.clear();
                    surnameTF.clear();
                    firstnameTF.clear();
                    departmentTF.clear();
                }
            }
        });

        inputBox.getChildren().addAll(idTF, surnameTF, firstnameTF, departmentTF, addButton);
        inputBox.setSpacing(5);

        // a VBox to contain all the above components
        VBox fullGUI = new VBox();
        fullGUI.setSpacing(5);
        fullGUI.setPadding(new Insets(10, 10, 10, 10));
        fullGUI.getChildren().addAll(label, staffTable, inputBox);

        // Put that box into a scene, and the scene onto the primary stage
        Scene scene = new Scene(fullGUI, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Staff List Table Demo");
        primaryStage.show();

    }
}
