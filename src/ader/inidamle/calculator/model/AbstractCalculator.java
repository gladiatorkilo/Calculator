package ader.inidamle.calculator.model;

import ader.inidamle.calculator.observer.Observable;
import ader.inidamle.calculator.observer.Observer;

import java.util.ArrayList;

public abstract class AbstractCalculator implements Observable {

    private ArrayList<Observer> mObservers = new ArrayList<>();

    abstract public void input(String data);

    abstract public String output();

    @Override
    public void addObserver(Observer observer) {
        mObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        mObservers.remove(observer);
    }

    @Override
    public void clearObservers() {
        mObservers.clear();
    }

    @Override
    public void notifyObservers() {
        mObservers.stream().forEach(pObserver -> pObserver.update(this));
    }
}
