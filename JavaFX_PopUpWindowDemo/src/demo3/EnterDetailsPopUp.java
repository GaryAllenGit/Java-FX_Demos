package demo3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

class EnterDetailsPopUp extends Stage {

    EnterDetailsPopUp(Demo3 parent) {

        this.initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label firstnameLbl = new Label("First Name:");
        Label surnameLbl = new Label("Surname:");
        Label deptLbl = new Label("Department");
        Label idLbl = new Label("ID:");

        TextField firstnameTF = new TextField();
        TextField surnameTF = new TextField();
        TextField deptTF = new TextField();
        TextField idTF = new TextField();

        Button btn = new Button("Done");
        btn.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                String id = idTF.getText();
                String fn = firstnameTF.getText();
                String sn = surnameTF.getText();
                String dept = deptTF.getText();
                parent.setEmployee(id, fn, sn, dept);
                EnterDetailsPopUp.this.close();
            }
        });

        grid.add(idLbl,0,0);
        grid.add(idTF,1,0);
        grid.add(surnameLbl,0,1);
        grid.add(surnameTF,1,1);
        grid.add(firstnameLbl,0,2);
        grid.add(firstnameTF,1,2);
        grid.add(deptLbl,0,3);
        grid.add(deptTF,1,3);
        grid.add(btn,0,4);

        Scene dialogScene = new Scene(grid, 375,200);
        this.setScene(dialogScene);
    }
}
