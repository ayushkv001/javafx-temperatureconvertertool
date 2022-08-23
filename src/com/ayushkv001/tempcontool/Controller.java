package com.ayushkv001.tempcontool;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Label welcomeLabel;
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField textField;
    @FXML
    public javafx.scene.control.Button btn;

    private static final String ctf = "Celsius to Fahrenheit";
    private static final String ftc = "Fahrenheit to Celsius";
    private boolean isctf =true;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        choiceBox.getItems().add(ctf);
        choiceBox.getItems().add(ftc);
        choiceBox.setValue(ctf);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
//            System.out.println(t1);
            if(t1.equals(ctf)){
                isctf=true;
            }
            else isctf=false;
        });

        btn.setOnAction(actionEvent -> {
            covert();
//            System.out.println("Button Clicked");
        });

    }

    private void covert() {
        String input = textField.getText();
        try{
            float temp = Float.parseFloat(input);
            float newTemp = 0.00f;
            if(isctf){
                newTemp = (temp * 9 / 5) + 32;
            }
            else {
                newTemp = (temp-32)*5/9;
            }
            display(newTemp);
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please enter number");
            alert.show();
        }

    }

    private void display(float newTemp) {
        String unit = isctf?"F":"C";
        System.out.println(newTemp+unit);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The converted temperature is "+newTemp+unit);
        alert.show();
    }
}
