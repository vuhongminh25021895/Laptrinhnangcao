package com.javaproject.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.scene.control.Button;

public class PriceCompareLogic extends Application {
    private double nowPrice = 0;
    Stage window;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("title");

        TextField priceInput = new TextField();
        Label currPrice = new Label("Current price: " + 0);
        Button submitPriceButton = new Button("Submit price");

        submitPriceButton.setOnAction(e->{
            if (isInt(priceInput, priceInput.getText())){
                double newPrice = Integer.parseInt(priceInput.getText());
                if (newPrice > nowPrice){
                    nowPrice = newPrice;
                    currPrice.setText("Current price: " + newPrice);
                }else{
                    currPrice.setText("Current price: " + nowPrice);
                }
            }else{
                currPrice.setText("Not a valid input");
            }
        });


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(priceInput,submitPriceButton,currPrice);

        Scene scene = new Scene(layout, 500, 400);
        window.setScene(scene);
        window.show();
    }

    private boolean isInt(TextField input, String msg){
        try{
            int price = Integer.parseInt(input.getText());
            System.out.println("Current price: " + price);
            return true;
        }catch (NumberFormatException e){
            System.out.println("Error: " + msg + " is not a number");
        }
        return false;
    }
}
