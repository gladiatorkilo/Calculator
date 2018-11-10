package com.inidamleader.calculator.model;

public class Operand {

    private String stringValue = "0";
    private double doubleValue = 0;

    public void input(String pData) {
        switch (pData) {
            case "+/-":
                reverseSign();
                break;
            case "<-":
                remove();
                break;
            default:
                add(pData);
                break;
        }
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    private void setStringValue(String pStringValue) {
        stringValue = pStringValue;
        doubleValue = Double.valueOf(pStringValue);
    }

    private void add(String pData) {
        if (pData.equals(".")) {
            if (!getStringValue().contains("."))
                setStringValue(getStringValue() + pData);
        } else {
            if (getStringValue().equals("0"))
                setStringValue(pData);
            else
                setStringValue(getStringValue() + pData);
        }
    }

    private void remove() {
        if (getStringValue().contains("-")) {
            if (getStringValue().length() > 2)
                setStringValue(getStringValue().substring(0, getStringValue().length() - 1));
            else if (getStringValue().length() == 2)
                setStringValue("0");
        } else {
            if (getStringValue().length() > 1)
                setStringValue(getStringValue().substring(0, getStringValue().length() - 1));
            else if (getStringValue().length() == 1)
                setStringValue("0");
        }
    }

    private void reverseSign() {
        if (getStringValue().contains("-"))
            setStringValue(getStringValue().substring(1));
        else if (doubleValue != 0)
            setStringValue("-" + getStringValue());
    }
}