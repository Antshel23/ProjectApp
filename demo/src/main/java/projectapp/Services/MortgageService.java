package projectapp.Services;

import org.springframework.stereotype.Service;
import projectapp.Models.MortgageModel;

@Service
public class MortgageService {
    public double calculateMonthlyRepayment(MortgageModel mortgageModel) {
        if ((mortgageModel.getInterestRate() <= 0) || (mortgageModel.getTermYears() <= 0) || (mortgageModel.getPropertyValue() <= 0) || (mortgageModel.getCurrentEquity() <= 0)) {
            throw new IllegalArgumentException("Invalid data submitted");
        }
        double principal = mortgageModel.getPropertyValue() - mortgageModel.getCurrentEquity();
        double interestRate = mortgageModel.getInterestRate() / 100 / 12;
        double termMonths = mortgageModel.getTermYears() * 12;
        double monthlyRepayment = (principal * interestRate) / (1 - Math.pow(1 + interestRate, -termMonths));
        return monthlyRepayment;
    }
}
