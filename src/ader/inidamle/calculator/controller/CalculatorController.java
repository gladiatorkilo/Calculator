package ader.inidamle.calculator.controller;

import ader.inidamle.calculator.model.AbstractCalculator;
import ader.inidamle.calculator.model.Calculator;
import ader.inidamle.calculator.observer.Observable;
import ader.inidamle.calculator.observer.Observer;
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