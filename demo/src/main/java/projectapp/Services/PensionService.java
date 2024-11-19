package projectapp.Services;

import org.springframework.stereotype.Service;
import projectapp.Models.PensionModel;

@Service
public class PensionService {
    public double calculateRetirementPot(PensionModel pensionModel) {
        double currentPot = pensionModel.getCurrentPot();
        double portfolioInterestGain = 1.055;
        double yearsToRetirement = calculateYearsToRetirement(pensionModel);
        
        for (int i = 0; i < yearsToRetirement; i++) {
            currentPot += calculateYearlyContribution(pensionModel) * portfolioInterestGain;
        }
        return currentPot;
    }

    public double calculateLumpSum(PensionModel pensionModel) {
        return calculateRetirementPot(pensionModel) * 0.25;
    }

    public double calculateDrawdown(PensionModel pensionModel) {
        return calculateRetirementPot(pensionModel) / calculateRetirementLength(pensionModel);
    }

    public double calculateDrawdownWithLumpSum(PensionModel pensionModel) {
        double finalPot = calculateRetirementPot(pensionModel);
        double lumpSum = finalPot * 0.25;
        return (finalPot -= lumpSum) / calculateRetirementLength(pensionModel);
    }

    public int calculateRetirementLength(PensionModel pensionModel) {
        return 85 - pensionModel.getRetirementAge();
    }

    public double calculateYearlyContribution(PensionModel pensionModel) {
        double totalContribution =  pensionModel.getEmployerContribution() + pensionModel.getPersonalContribution();
        return pensionModel.getTotalAnnualIncome() * totalContribution;
    }

    public double calculateYearsToRetirement(PensionModel pensionModel) {
        return pensionModel.getRetirementAge() - pensionModel.getAge();
    }
}

