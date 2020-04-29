package com.company;
import java.awt.Desktop;
import com.company.util.FileHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class App extends Application {
    
    private static FileHandler fileHandler;
    private static FileChooser fileChooser;
    private static TextArea textArea;
    private static Stage steissi;
    private static String tallennus;
    
        public void avaa(ActionEvent event) {
            File tiedosto = App.getFileChooser().showOpenDialog(App.getPrimaryStage());
            String kokoPolku = tiedosto.getAbsolutePath();
            App.getFileHandler().setTekstiTiedosto(kokoPolku);
            App.getTextArea().setText(App.getFileHandler().openFile());
            /*System.out.println(App.getFileHandler().getTekstiTiedosto());
            System.out.println(App.getFileHandler().getTekstiTiedosto());
            System.out.println("Open");
           */
           App.setTallennus(App.getFileHandler().getTekstiTiedosto());
           tallennus = (App.getFileHandler().getTekstiTiedosto());
        }

        public void tallenna (ActionEvent event) {
            App.getFileHandler().setTekstiTiedosto(fileHandler.getTekstiTiedosto());
            App.getFileHandler().saveFile(App.getTextArea().getText());
        }   

        public static Stage getPrimaryStage() {
            return steissi;
        }
        private void setPrimaryStage(Stage steissi){
            App.steissi = steissi;
        }

        public static FileChooser getFileChooser() {
            return fileChooser;
        }
        private void setFileChooser(FileChooser fileChooser){
            App.fileChooser = fileChooser;
        }

        public static FileHandler getFileHandler() {
            return fileHandler;
        }
        private void setFileHandler(FileHandler fileHandler){
            App.fileHandler = fileHandler;
        }

        public static TextArea getTextArea() {
            return textArea;
        }
        private void setTextArea(TextArea textArea){
            App.textArea = textArea;
        }

        public static String getTallennus() {
            return tallennus;
        }
        private static void setTallennus(String tallennus){
            App.tallennus = tallennus;
        } 


    @Override
    public void start(Stage primaryStage) {
        
        //this.steissi = primaryStage;
        setPrimaryStage(primaryStage);
        steissi = primaryStage;

        FileChooser fileChooser = new FileChooser();
        setFileChooser(fileChooser);
        fileChooser = fileChooser;
        
        fileHandler = new FileHandler();
        setFileHandler(fileHandler);
        fileHandler = fileHandler;

        TextArea textArea = new TextArea();
        setTextArea(textArea);
        textArea = textArea;


        primaryStage.setTitle("JavaFX App");

        MenuBar menuBar = new MenuBar();

        
        textArea.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        ColorPicker colorPicker = new ColorPicker();
        Color value = colorPicker.getValue();
        VBox vBox = new VBox(colorPicker, menuBar, textArea);
        Menu menu1 = new Menu("File");
        MenuItem menuItem1 = new MenuItem("New");
        
        
        
        MenuItem menuItem2 = new MenuItem("Open");
        menuItem2.setOnAction(this::avaa);
       /* menuItem2.setOnAction(new EventHandler<ActionEvent>() {
        @Override
            public void avaa(ActionEvent event) {
            File tiedosto = fileChooser.showOpenDialog(primaryStage);
            String kokoPolku = tiedosto.getAbsolutePath();
            fileHandler.setTekstiTiedosto(kokoPolku);
            textArea.setText(fileHandler.openFile());
            System.out.println(fileHandler.getTekstiTiedosto());
            System.out.println(fileHandler.getTekstiTiedosto());
            System.out.println("Save");
           
              }
        });  */      
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
        //ColorPicker colorPicker = new ColorPicker();
        
        
    
        //(e -> {

            
            /*File tiedosto = fileChooser.showOpenDialog(primaryStage);
            String kokoPolku = tiedosto.getAbsolutePath();
            fileHandler.setTekstiTiedosto(kokoPolku);
            textArea.setText(fileHandler.openFile());
            System.out.println(fileHandler.getTekstiTiedosto());*/
            
       // });
        
        
         
       menuItem3.setOnAction(this::tallenna);
            //System.out.println("tve");
      /*    System.out.println(fileHandler.getTekstiTiedosto()); 
            fileHandler.setTekstiTiedosto(fileHandler.getTekstiTiedosto());
            fileHandler.saveFile(textArea.getText());
        */ 
       // });
       
        menuItem7.setOnAction(er -> {
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