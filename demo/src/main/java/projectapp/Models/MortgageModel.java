package projectapp.Models;

public class MortgageModel {

private double interestRate;
private double termYears;
private double currentEquity;
private double propertyValue;

    public MortgageModel(double interestRate, int termYears, double currentEquity, double propertyValue) {
    if (interestRate <= 0) {
        throw new IllegalArgumentException("Interest rate must be greater than 0");
    }
    if (termYears <= 0) {
        throw new IllegalArgumentException("Term must be greater than 0");
    }
    if (currentEquity <= 0) {
        throw new IllegalArgumentException("Current equity / deposit must be greater than 0");
    }
    if (propertyValue <= 0) {
        throw new IllegalArgumentException("Property value must be greater than 0");
    }

    this.interestRate = interestRate;
    this.termYears = termYears;
    this.currentEquity = currentEquity;
    this.propertyValue = propertyValue;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate <= 0) {
            throw new IllegalArgumentException("Interest rate must be greater than 0");
        }
        this.interestRate = interestRate;
    }

    public double getTermYears() {
        return termYears;
    }

    public void setTermYears(double termYears) {
        if (termYears <= 0) {
            throw new IllegalArgumentException("Term must be greater than 0");
        }
        this.termYears = termYears;
    }

    public double getCurrentEquity() {
        return currentEquity;
    }

    public void setCurrentEquity(double currentEquity) {
        if (currentEquity <= 0) {
            throw new IllegalArgumentException("Current equity / deposit must be greater than 0");
        }
        this.currentEquity = currentEquity;
    }

    public double getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(double propertyValue) {
        if (propertyValue <= 0) {
            throw new IllegalArgumentException("Property value must be greater than 0");
        }
        this.propertyValue = propertyValue;
    }
}
