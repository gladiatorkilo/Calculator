package com.inidamleader.calculator.controller;

import com.inidamleader.calculator.model.AbstractCalculator;
import com.inidamleader.calculator.model.Calculator;
import com.inidamleader.calculator.observer.Observable;
import com.inidamleader.calculator.observer.Observer;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController implements Observer {
    @FXML
    private Label output;

    private AbstractCalculator mCalculator;

    public CalculatorController() {
        mCalculator = new Calculator();
        mCalculator.addObserver(this);
    }

    @FXML
    public void click(Event event) {
        mCalculator.input(((Button) event.getSource()).getText());
    }

    @Override
    public void update(Observable observable) {
        output.setText(((AbstractCalculator) observable).output());
    }
}