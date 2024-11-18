package projectapp.Services;

import org.springframework.stereotype.Service;
import projectapp.Models.TaxModel;

@Service
public class TaxService {
    
    public double calculateTakeHomeYearlyPay(TaxModel taxModel) {
            double totalDeductions = calculateStudentLoanOwed(taxModel);
            return taxModel.getBaseSalary() - totalDeductions;
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
}

