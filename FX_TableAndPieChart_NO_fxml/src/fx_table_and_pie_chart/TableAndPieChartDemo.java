package fx_table_and_pie_chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class TableAndPieChartDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        ObservableList<PieChart.Data> emailData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Monday", 75),
                        new PieChart.Data("Tuesday", 58),
                        new PieChart.Data("Wednesday", 52),
                        new PieChart.Data("Thursday", 59),
                        new PieChart.Data("Friday", 58),
                        new PieChart.Data("Saturday", 15),
                        new PieChart.Data("Sunday", 10));

        PieChart chart = new PieChart(emailData);
        chart.setTitle("Daily Emails Received");

        TableView tv = new TableView<>(emailData);
        tv.setEditable(true);

        TableColumn column1  = new TableColumn("Day");
        column1.setPrefWidth(120);
        column1.setCellValueFactory(new PropertyValueFactory("name"));
        column1.setCellFactory(TextFieldTableCell.forTableColumn());
        column1.setEditable(false);

        TableColumn column2 = new TableColumn("No. of Emails");
        column2.setPrefWidth(120);
        column2.setCellValueFactory(new PropertyValueFactory("pieValue"));
        column2.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));

        tv.getColumns().addAll(column1,column2);

        Scene scene = new Scene(new HBox(tv, chart));

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Table and Pie Chart Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}


