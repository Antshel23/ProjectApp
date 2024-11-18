package projectapp.Models;

public class TaxModel {
    protected double baseSalary;
    protected int studentLoanPlan;
    protected double pensionContribution;
    protected double bonusIncome;

    public TaxModel(double baseSalary, int studentLoanPlan, double pensionContribution, double bonusIncome) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary cannot be negative");
        }
        if (studentLoanPlan != 0 && studentLoanPlan != 1 && studentLoanPlan != 2 ) {
            throw new IllegalArgumentException("Please select 0 for no student loan, or 1 / 2 for respective plans");
        }
        if (pensionContribution < 0) {
            throw new IllegalArgumentException("Pension contribution cannot be negative");
        }
        if (bonusIncome < 0) {
            throw new IllegalArgumentException("Bonus income cannot be negative");
        }

        this.baseSalary = baseSalary;
        this.studentLoanPlan = studentLoanPlan;
        this.pensionContribution = pensionContribution;
        this.bonusIncome = bonusIncome;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setStudentLoanPlan(int studentLoanPlan) {
        this.studentLoanPlan = studentLoanPlan;
    }

    public int getStudentLoanPlan() {
        return studentLoanPlan;
    }

    public void setPensionContribution(double pensionContribution) {
        this.pensionContribution = pensionContribution;
    }

    public double getPensionContribution() {
        return pensionContribution;
    }

    public void setBonusIncome(double bonusIncome) {
        this.bonusIncome = bonusIncome;
    }

    public double getBonusIncome() {
        return bonusIncome;
    }
}
