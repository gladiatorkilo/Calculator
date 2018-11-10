package com.inidamleader.calculator.observer;

public interface Observable {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void clearObservers();

    void notifyObservers();
}