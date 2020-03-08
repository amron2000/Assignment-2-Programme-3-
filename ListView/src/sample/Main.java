/////////////////////////// Q1 ////////////////////////////////////////////////
package sample;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;


public class Main extends Application {

    ListView<String> listView;
    ListView<String> listView2;

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("multiple-selection List");

        listView = new ListView<>();
        listView.getItems().addAll("Blue", "Red", "gray", "Black", "White");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        VBox vbox1 = new VBox();
        vbox1.setPadding(new Insets(20, 20, 20, 10));
        listView.setPrefWidth(95);
        listView.setPrefHeight(250);
        vbox1.getChildren().addAll(listView);
        //
        // Second ListView
        //
        listView2 = new ListView<>();
        listView2.getItems().addAll();

        VBox vbox2 = new VBox();
        vbox2.setPadding(new Insets(20, 10, 20, 20));
        listView2.setPrefWidth(95);
        listView2.setPrefHeight(250);
        vbox2.getChildren().addAll(listView2);

        Button button = new Button("Click");
        button.setStyle("-fx-font-size:12");
        button.setOnAction(event -> buttonclicked());
        button.setPrefSize(150, 30);

        BorderPane border = new BorderPane();
        border.setLeft(vbox1);
        border.setRight(vbox2);
        border.setCenter(button);

        window.setScene(new Scene(border, 300, 275));
        window.show();
    }




    private void buttonclicked(){
        String selectedItem = listView.getSelectionModel().getSelectedItem();
        if (selectedItem == null ){
            Alert n = new Alert(Alert.AlertType.WARNING);
            n.setHeaderText("No item selections");
            n.show();
        }else{
            //listView2.getItems().addAll(selectedItem);
        listView2.getItems().addAll(listView.getSelectionModel().getSelectedItems());
        listView.getSelectionModel().clearSelection();
        }

    }


    public static void main(String[] args) { launch(args); }
}
