package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class Main extends Application {


    public void start(Stage window) throws IOException, FileNotFoundException {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 20, 10, 30));
        grid.setHgap(0);
        grid.setVgap(5);

        // Welcome Label
        Label welcome = new Label("Welcome");
        welcome.setId("Welcome");
        grid.add(welcome, 0, 0);

        // Label Username
        Label textLabel = new Label("User Name:");
        textLabel.setId("label");
        grid.add(textLabel, 0, 1);
        // Input Username
        TextField Userinput = new TextField();

        HBox hbox1 = new HBox(Userinput);
        grid.add(hbox1, 1, 1);
        // Label Password
        Label PassLabel = new Label("Password:");
        PassLabel.setId("label");
        grid.add(PassLabel, 0, 2);
        // Input Password
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Your password");
        HBox hbox2 = new HBox(passwordField);
        grid.add(hbox2, 1, 2);
        // Buttons
        Button button1 = new Button("Sign up");
        Label label = new Label("");
        grid.add(label, 1, 8);
//////////////////////////////// Log in ///////////////////////////////////
        String filepath = "password.txt";
        File file = new File(filepath);
        file.createNewFile();
        Scanner scanner = new Scanner(file);
         /*        Acounts is amro amron123
                   khaled amron123
                   amron2000 amron123
         */
        button1.setOnAction(event -> {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(Userinput.getText()) && line.contains(getMd5(passwordField.getText()))) {
////////////////////////////////////////// Scene 2 //////////////////////////////////////////////////
                    Button button3 = new Button("Add Student");
                    button3.setId("Buttons");
                    Button button4 = new Button("View Student");
                    button4.setId("Buttons");
                    VBox vbox = new VBox(10, button3, button4);
                    vbox.setAlignment(Pos.CENTER);
                    Scene scene2 = new Scene(vbox, 320, 270);
                    scene2.getStylesheets().add("Css.css");
                    vbox.setId("BackGround");
                    window.setScene(scene2);
/////////////////////////////////////////////////////////////////////////////////////////////////////

                } else if (Userinput.getText().isEmpty() || passwordField.getText().isEmpty()) {
                    label.setText("User name or Password is empty");
                    label.setId("login");
                } else if (!Userinput.getText().equals("mah") || !passwordField.getText().equals("123")) {
                    label.setText("User name or Password wrong");
                    label.setId("login");
                }
            }
        });
        Button button2 = new Button("Exit");
        button2.setOnAction(event -> {
            System.exit(0);
        });
        button1.setId("Buttons");
        button2.setId("Buttons");
        HBox hbox3 = new HBox(8, button1, button2);
        hbox3.setPadding(new Insets(0, 0, 0, 48));
        grid.add(hbox3, 1, 6);

        grid.setId("BackGround");
        Scene scene = new Scene(grid, 320, 270);
        scene.getStylesheets().add("Css.css");
        window.setTitle("Hello World");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}



