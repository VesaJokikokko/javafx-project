package com.company;

import com.company.util.FileHandler;
import javafx.application.Application;

import java.io.File;
import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class App extends Application {
    private FileHandler fileHandler;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        fileHandler = new FileHandler();
        primaryStage.setTitle("JavaFX App");

        MenuBar menuBar = new MenuBar();
        TextArea textArea = new TextArea();
        VBox vBox = new VBox(menuBar, textArea);
        Menu menu1 = new Menu("File");
        MenuItem menuItem1 = new MenuItem("New");
        MenuItem menuItem2 = new MenuItem("Open");
        MenuItem menuItem3 = new MenuItem("Save");
        menu1.getItems().add(menuItem1);
        menu1.getItems().add(menuItem2);
        menu1.getItems().add(menuItem3);
        Menu menu2 = new Menu("Edit");
        MenuItem menuItem4 = new MenuItem("Undo");
        MenuItem menuItem5 = new MenuItem("Redo");
        menu2.getItems().add(menuItem4);
        menu2.getItems().add(menuItem5);
        Menu menu3 = new Menu("About");
        MenuItem menuItem7 = new MenuItem("About");
        menu3.getItems().add(menuItem7);
        menuBar.getMenus().add(menu1);
        menuBar.getMenus().add(menu2);
        menuBar.getMenus().add(menu3);
        FileChooser fileChooser = new FileChooser();
        menuItem2.setOnAction(e -> {

            //FileHandler fh = new FileHandler("c:/Users/javafx-project/src/main/com.company/App.java");
            fileHandler.setTekstiTiedosto("testi.txt");
            textArea.setText(fileHandler.openFile());

        });
        menuItem3.setOnAction(e -> {
            fileHandler.setTekstiTiedosto("testi.txt");
            fileHandler.saveFile(textArea.getText());
        });
        menuItem7.setOnAction(e -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Tekstieditori");
            alert.setHeaderText("Tietoa ohjelmasta");
            alert.setContentText("Tämän ohjelman on tehnyt Vesa Jokikokko vuonna 2020");

            alert.showAndWait();
        });


        Scene scene = new Scene(vBox);



        primaryStage.setScene(scene);
        primaryStage.show();


    }
}