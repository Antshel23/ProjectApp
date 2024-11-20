package projectapp.Services;

import org.springframework.stereotype.Service;
import projectapp.Models.TaxModel;

@Service
public class TaxService {

    public double calculateTakeHomeYearlyPay(TaxModel taxModel) {
    return calculateTotalIncome(taxModel) - calculateTotalDeductions(taxModel);
    }

    public double calculateTakeHomeMonthlyPay(TaxModel taxModel) {
        double monthly = calculateTakeHomeYearlyPay(taxModel) / 12;
        return monthly;
    }

    public double calculateStudentLoanOwed(TaxModel taxModel) {
        int studentLoanPlan = taxModel.getStudentLoanPlan();
        double loanOwed = 0;
        double baseSalary = taxModel.getBaseSalary();
        switch (studentLoanPlan) {
            case 0:
                loanOwed = 0;
                break;
            case 1:
                if (baseSalary > 24990) {
                    loanOwed = (baseSalary - 24990) * 0.09;
                }
                break;
            case 2:
                if (baseSalary > 27295) {
                    loanOwed = (baseSalary - 27295) * 0.09;
                }
                break;
        default:
        throw new IllegalArgumentException("Error");
        }
        return loanOwed;
    }

    public double calculatePensionContribution(TaxModel taxModel) {
        return taxModel.getPensionContribution();
    }

    public double calculateTotalIncome(TaxModel taxModel) {
        return taxModel.getBaseSalary() + taxModel.getBonusIncome();
    }

    public double calculateTaxableIncome(TaxModel taxModel) {
        return calculateTotalIncome(taxModel) - (taxModel.getPensionContribution() + calculateStudentLoanOwed(taxModel));
    }

    public double calculateTotalDeductions(TaxModel taxModel) {
        return calculateNationalInsuranceOwed(taxModel) +
         calculatePensionContribution(taxModel) +
         calculateStudentLoanOwed(taxModel) +
         calculateTaxOwed(taxModel);
    }

    public double calculateTaxOwed(TaxModel taxModel) {
        double taxableIncome = calculateTaxableIncome(taxModel);
        double personalAllowance = 12570;
        if (taxableIncome < personalAllowance) {
            return taxableIncome;
        }
        else if (taxableIncome < 50270) {
            return (taxableIncome - personalAllowance) * 0.2;
        }
        else if (taxableIncome < 125140) {
            double threshold1 = (50270 - personalAllowance) * 0.2;
            double threshold2 = (taxableIncome - threshold1) * 0.4;
            return threshold1 + threshold2;
        }
        else {
            double threshold1 = 50270 * 0.2;
            double threshold2 = 74970 * 0.4;
            double threshold3 = (taxableIncome - 125140) * 0.45;
            return threshold1 + threshold2 + threshold3;
        }
    }

    public double calculateNationalInsuranceOwed(TaxModel taxModel) {
        double weeklyIncome = taxModel.getBaseSalary() / 52;
        if (weeklyIncome < 242) {
            return 0;
        }
        else if (weeklyIncome < 967) {
            return (weeklyIncome-242) * 0.08 * 52;
        }
        else {
            return ((((967-242) * 0.08) + (weeklyIncome-967)*0.02) * 52);
        }
    }
}

