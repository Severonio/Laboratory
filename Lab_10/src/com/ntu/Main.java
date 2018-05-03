package com.ntu;

import com.ntu.ui.LoadRegisterUI;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main  extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new LoadRegisterUI(), 1000, 800));
        stage.setTitle("Enterprise system");
        stage.show();
    }
}
