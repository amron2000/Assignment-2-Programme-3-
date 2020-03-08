package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage window) throws Exception{
        window.setTitle("Hello World");

        // Text label
        Label textLabel = new Label("Enter Celsius temperature:");
        textLabel.setPadding(new Insets(30,10,10,85));
        textLabel.setAlignment(Pos.CENTER);
        // Input label
        TextField text = new TextField();


        // Radio buttons
        Label result = new Label();
        RadioButton radio1 = new RadioButton();
        radio1.setText("Fahrenheit");
        radio1.setOnAction(event -> {

             double value = Double.parseDouble(text.getText());
            result.setText("New Tem is "+( value* 9/5 + 32));
            result.setPadding(new Insets(0,0,10,75));

        });
        //
        RadioButton radio2 = new RadioButton();
        radio2.setText("Kelvin");
        radio2.setPadding(new Insets(10,10,10,10));
        radio2.setOnAction(event -> {

            double value = Double.parseDouble(text.getText());
            result.setText("New Tem is "+ (value + 273.15));
            result.setPadding(new Insets(0,0,10,75));

        });
        //
        ToggleGroup group = new ToggleGroup();
        radio1.setToggleGroup(group);
        radio2.setToggleGroup(group);

        // GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,50));
        GridPane.setConstraints(radio1, 0, 0);
        GridPane.setConstraints(radio2, 1, 0);
        grid.getChildren().addAll(radio1,radio2);




         // VBox Layout
         VBox vbox = new VBox(2,textLabel,text,grid,result);

        window.setScene(new Scene(vbox, 300, 275));
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
