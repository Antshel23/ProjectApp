package projectapp.Services;

import org.springframework.stereotype.Service;
import projectapp.Models.PensionModel;

@Service
public class PensionService {
    public double calculateRetirementPot(PensionModel pensionModel) {
        return 0;
    }

    public double calculateLumpSumAndDrawdown(PensionModel pensionModel) {
        return 0;
    }

    public double calculateDrawdownOnly(PensionModel pensionModel) {
        return 0;
    }

    public double calculateYearlyContribution(PensionModel pensionModel) {
        double totalContribution =  pensionModel.getEmployerContribution() + pensionModel.getPersonalContribution();
        return pensionModel.getTotalAnnualIncome() * totalContribution;
    }

    public double calculateYearsToRetirement(PensionModel pensionModel) {
        return pensionModel.getRetirementAge() - pensionModel.getAge();
    }
}

