package com.fahimshahrierrasel.tipcalculator;

public class TipCalculation {
    private double subTotal;
    private float tipPercent;
    private int numPerson;

    public TipCalculation(double subTotal) {
        this.subTotal = subTotal;
        tipPercent = 0.0f;
        numPerson = 1;
    }

    public TipCalculation(double subTotal, float tipPercent) {
        this.subTotal = subTotal;
        this.tipPercent = tipPercent;
        this.numPerson = 1;
    }

    public TipCalculation(double subTotal, float tipPercent, int numPerson) {
        this.subTotal = subTotal;
        this.tipPercent = tipPercent;
        this.numPerson = (numPerson == 0) ? 1 : numPerson;
    }

    public double calculateTip(){
        return subTotal * (tipPercent/100);
    }

    public double calculateTotalBill(){
        return subTotal + calculateTip();
    }

    public double billPerPerson(){
        return calculateTotalBill()/numPerson;
    }

    public double tipPerPerson(){
        return calculateTip() / numPerson;
    }
}
