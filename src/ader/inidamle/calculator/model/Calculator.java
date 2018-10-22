package ader.inidamle.calculator.model;

import java.util.ArrayList;

public class Calculator extends AbstractCalculator {

    private Operand mOperand;
    private String mOperator;
    private double mDoubleResult;
    private String mStringResult;
    private boolean operatorChanged;

    public Calculator() {
        mOperand = new Operand();
        mOperator = null;
        mDoubleResult = 0;
        mStringResult = "0";
        operatorChanged = false;
    }

    public void input(String data) {
        String[] t = new String[]{"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "+/-", "<-"};
        ArrayList<String> operands = new ArrayList<>();
        for (String string : t) {
            operands.add(string);
        }

        if (operands.contains(data)) {
            mOperand.input(data);
            setStringResult(mOperand.getStringValue());
            operatorChanged = false;
        } else {
            if ("+-x/".contains(data)) {
                switch (data) {
                    case "+":
                        setOperator("+");
                        break;
                    case "-":
                        setOperator("-");
                        break;
                    case "x":
                        setOperator("x");
                        break;
                    case "/":
                        setOperator("/");
                        break;
                }
            } else if (data.equals("=")) {
                setOperator(null);
            } else if (data.equals("C")) {
                mOperand = new Operand();
                setOperator(null);
                mDoubleResult = 0;
                setStringResult("0");
                operatorChanged = false;
            }
        }
    }

    private void updateResult() {
        if (mOperator == null)
            mDoubleResult = mOperand.getDoubleValue();
        else
            switch (mOperator) {
                case "+":
                    mDoubleResult += mOperand.getDoubleValue();
                    break;
                case "-":
                    mDoubleResult -= mOperand.getDoubleValue();
                    break;
                case "x":
                    mDoubleResult *= mOperand.getDoubleValue();
                    break;
                case "/":
                    mDoubleResult /= mOperand.getDoubleValue();
                    break;
            }
    }

    public String output() {
        return mStringResult;
    }

    private void setOperator(String pOperator) {
        if (!operatorChanged) {
            updateResult();
            setStringResult(formatPointZero(String.valueOf(mDoubleResult)));
            mOperand = new Operand();
        }
        mOperator = pOperator;
        operatorChanged = true;
    }

    private void setStringResult(String pS) {
        mStringResult = pS;
        notifyObservers();
    }

    private String formatPointZero(String pS) {
        if (pS.length() > 2 && pS.endsWith(".0")) {
            pS = pS.substring(0, pS.length() - 2);
        }
        return pS;
    }
}
