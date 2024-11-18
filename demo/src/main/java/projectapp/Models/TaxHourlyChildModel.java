package projectapp.Models;

public class TaxHourlyChildModel extends TaxModel {

protected double hourlyWage;
protected double averageWeeklyHours;

    public TaxHourlyChildModel(double hourlyWage, double averageWeeklyHours, double baseSalary, int studentLoanPlan, double pensionContribution, double bonusIncome) {
    super(0, studentLoanPlan, pensionContribution, bonusIncome);
    this.hourlyWage = hourlyWage;
    this.averageWeeklyHours = averageWeeklyHours;
    this.baseSalary = calculateBaseSalary();
    }

    public double calculateBaseSalary() {
        return hourlyWage * averageWeeklyHours;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setAverageWeeklyHours(double averageWeeklyHours) {
        this.averageWeeklyHours = averageWeeklyHours;
    }

    public double getAverageWeeklyHours() {
        return averageWeeklyHours;
    }
}