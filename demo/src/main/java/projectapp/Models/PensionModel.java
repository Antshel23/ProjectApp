package projectapp.Models;

public class PensionModel {
private double totalAnnualIncome;
private double personalContribution;
private double employerContribution;
private double currentPot;
private int age;
private int retirementAge;

public PensionModel(double totalAnnualIncome, double personalContribution, double employerContribution, double currentPot, int age, int retirementAge) {
    if (totalAnnualIncome <= 0) {
        throw new IllegalArgumentException("Annual income must be greater than 0");
    }
    if (personalContribution + employerContribution <= 0 && personalContribution < 100) {
        throw new IllegalArgumentException("Combined contributions must be greater than 0");
    }
    if (personalContribution < 0) {
        throw new IllegalArgumentException("Personal contribution cannot be negative");
    }
    if (employerContribution < 0) {
        throw new IllegalArgumentException("Employer contribution cannot be negative");
    }
    if (currentPot < 0) {
        throw new IllegalArgumentException("Current pot cannot be negative");
    }
    if (age < 17) {
        throw new IllegalArgumentException("You must be 18 or older");
    }
    if (retirementAge <= age) {
        throw new IllegalArgumentException("Retirement must be in the future");
    }

    this.totalAnnualIncome = totalAnnualIncome;
    this.personalContribution = personalContribution / 100;
    this.employerContribution = employerContribution / 100;
    this.currentPot = currentPot;
    this.age = age;
    this.retirementAge = retirementAge;
}

public double getTotalAnnualIncome() {
    return totalAnnualIncome;
}

public void setTotalAnnualIncome(double totalAnnualIncome) {
    this.totalAnnualIncome = totalAnnualIncome;
}

public double getPersonalContribution() {
    return personalContribution;
}

public void setPersonalContribution(double personalContribution) {
    this.personalContribution = personalContribution;
}

public double getEmployerContribution() {
    return employerContribution;
}

public void setEmployerContribution(double employerContribution) {
    this.employerContribution = employerContribution;
}

public double getCurrentPot() {
    return currentPot;
}

public void setCurrentPot(double currentPot) {
    this.currentPot = currentPot;
}

public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}

public int getRetirementAge() {
    return retirementAge;
}

public void setRetirementAge(int retirementAge) {
    this.retirementAge = retirementAge;
}
}
