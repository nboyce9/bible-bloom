package com.nboyce.bible_bloom.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomepageController {
    @FXML
    Label label;
    public void greet(){
        label.setText("Hello, World!");
    }
}
