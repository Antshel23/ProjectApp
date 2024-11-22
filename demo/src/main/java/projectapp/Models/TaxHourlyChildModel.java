package projectapp.Models;

public class TaxHourlyChildModel extends TaxModel {

protected double hourlyWage;
protected double averageWeeklyHours;

    public TaxHourlyChildModel(double hourlyWage, double averageWeeklyHours, int studentLoanPlan, double pensionContribution, double bonusIncome) {
    super(hourlyWage*averageWeeklyHours*52, studentLoanPlan, pensionContribution, bonusIncome);
    this.hourlyWage = hourlyWage;
    this.averageWeeklyHours = averageWeeklyHours;
    this.baseSalary = calculateBaseSalary();
    }

    @Override
    public double getBaseSalary() {
        return hourlyWage * averageWeeklyHours * 52;
    }

    @Override
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double calculateBaseSalary() {
        return hourlyWage * averageWeeklyHours * 52;
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
