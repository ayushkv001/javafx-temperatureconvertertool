package com.ayushkv001.tempcontool;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application{

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("front.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0,menuBar);

        primaryStage.setTitle("TCT");
        primaryStage.setScene(new Scene(rootNode,200,200));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    private MenuBar createMenu() {
        //Creating Menu bar
        Menu file = new Menu("File");
        MenuItem New = new MenuItem("New");
        New.setOnAction(actionEvent -> System.out.println("new menuItem clicked"));
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quit = new MenuItem("Quit");
        quit.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });
        file.getItems().addAll(New,separatorMenuItem,quit);

        Menu help = new Menu("Help");
        MenuItem about = new MenuItem("About");
        about.setOnAction(actionEvent -> aboutApp());
        help.getItems().addAll(about);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(file,help);
        return menuBar;
    }

    private void aboutApp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Title");
        alert.setHeaderText("Hello Ayush");
        alert.setContentText("I am building Java Games");
        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");
        alert.getButtonTypes().setAll(yes,no);
//        alert.show();
        Optional<ButtonType> getBtn =  alert.showAndWait();
        if(getBtn.isPresent() && getBtn.get()==yes){
            //code
            System.out.println("Yes button clicked");
        } else if (getBtn.isPresent() && getBtn.get()==no) {
            //code
            System.out.println("No button clicked");
        }

    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) { launch(args); }
}
