package com.company;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Main extends Application {
    public void start(Stage stage) throws FileNotFoundException {
        String  originalPassword = "1000:ccc6c615b9c307a5f0ab9154a167da17:49f1970b38cd751095df0557513214ed2d597a84efbbd19c2ad533f03e1a403fedd3c3d77fc806bb8ffe44cbc0db301a36bf1e4947198d539b2ac9482c532d19";

        TextField textField = new TextField();
        PasswordField pwdField = new PasswordField();
        Button button = new Button("Submit");
        button.setTranslateX(265);
        button.setTranslateY(155);

        Label label1 = new Label("Hi Maxim ,please enter your Password");
        label1.setTranslateY(-100);
        label1.setTranslateX(310);
        Font labelFont = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15);
        label1.setFont(labelFont);
        Label label2 = new Label("Password: ");


        Text text = new Text("");
        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13);
        text.setFont(font);
        text.setTranslateX(15);
        text.setTranslateY(225);
        text.setFill(Color.BROWN);


        button.setOnAction(e -> {

            String pwd = pwdField.getText();
            try {
                if (PBKDF2HASH.validatePassword(pwd, originalPassword)) {
                    text.setText("Hello Maxim Catanoi ,welcome to your computer");
                } else {
                    text.setText("Wrong password, try again");
                }
            } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                noSuchAlgorithmException.printStackTrace();
            } catch (InvalidKeySpecException invalidKeySpecException) {
                invalidKeySpecException.printStackTrace();
            }
        });


        HBox box = new HBox(10);
        box.setPadding(new Insets(115, 5 , 10, -180));
        box.getChildren().addAll(label1,label2, pwdField);
        Group root = new Group(box, button, text);


        Scene scene = new Scene(root, 595, 250, Color.DODGERBLUE);
        stage.setTitle("Password Simulation");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}