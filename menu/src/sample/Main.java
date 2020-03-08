/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author LapCity
 */
public class Main extends Application {
    TextArea ar;
    @Override

    public void start(Stage primaryStage) {
        Evnt event = new Evnt();
        MenuBar bar = new MenuBar();

        Menu f = new Menu("File");
        MenuItem open = new MenuItem("open");
        MenuItem close = new MenuItem("close");
        MenuItem Exit = new MenuItem("Exit");
        f.getItems().setAll(open, close, Exit);
        Menu ed = new Menu("Edit");
        MenuItem Font = new MenuItem("Font");
        MenuItem color = new MenuItem("Color");
        ed.getItems().addAll(Font, color);
        bar.getMenus().addAll(f);
        bar.getMenus().add(ed);
        open.setOnAction(event);
        close.setOnAction(event);
        Exit.setOnAction(event);
        Font.setOnAction(event);
        color.setOnAction(event);
        ar = new TextArea();
        VBox box = new VBox(bar, ar);

        Scene scene = new Scene(box, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private class Evnt implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String menu = ((MenuItem) event.getSource()).getText();
            switch (menu) {
                case "open":
                    FileChooser fc = new FileChooser();
                    fc.setTitle("open File");
                    fc.setInitialDirectory(new File("."));
                    File select = fc.showOpenDialog(null);
                {
                    Scanner s;
                    ar.setText("");
                    ar.setWrapText(true);
                    try {
                        s = new Scanner(select);
                        while (s.hasNextLine()) {
                            ar.appendText(s.nextLine());

                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;

                case "close":
                    ar.clear();
                    break;
                case "Exit":
                    System.exit(1);
                    break;
                case "Font":
                    Dialog<String> dialogFont = new ChoiceDialog<>("8", "10", "12", "14", "16", "18", "20", "22", "24", "26", "30", "35", "40");
                    dialogFont.setHeaderText("Select the size of the Font from list");
                    dialogFont.setContentText("Available Sizes");
                    dialogFont.setTitle("Size Selection");
                    String font = dialogFont.showAndWait().get();
                    ar.setStyle("-fx-font-size: " + font + "px;");
                    break;
                case "Color":
                    Alert d = new Alert(Alert.AlertType.CONFIRMATION);
                    ColorPicker color = new ColorPicker();
                    d.setGraphic(color);
                    d.showAndWait();
                    String c = color.getValue().toString();
                    String clor = c.substring(2);
                    ar.setStyle("-fx-text-fill:#" + clor + ";");

                    break;

            }
        }

    }

}
