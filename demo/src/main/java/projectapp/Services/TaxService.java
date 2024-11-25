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
        return (taxModel.getPensionContribution() / 100) * calculateTotalIncome(taxModel);
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
    
        if (taxableIncome > 100000) {
            personalAllowance -= (taxableIncome - 100000) / 2;
            if (personalAllowance < 0) {
                personalAllowance = 0;
            }
        }
    
        double basicRateLimit = 50270;
        double higherRateLimit = 125140;
        double tax = 0;
    
        if (taxableIncome <= personalAllowance) {
            return 0;
        }
    
        if (taxableIncome <= basicRateLimit) {
            tax += (taxableIncome - personalAllowance) * 0.2;
        } else if (taxableIncome <= higherRateLimit) {
            tax += (basicRateLimit - personalAllowance) * 0.2;
            tax += (taxableIncome - basicRateLimit) * 0.4;
        } else {
            tax += (basicRateLimit - personalAllowance) * 0.2;
            tax += (higherRateLimit - basicRateLimit) * 0.4;
            tax += (taxableIncome - higherRateLimit) * 0.45;
        }
    
        return tax;
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

