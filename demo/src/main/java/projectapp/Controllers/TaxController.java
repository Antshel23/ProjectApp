package projectapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projectapp.Models.TaxHourlyChildModel;
import projectapp.Models.TaxModel;
import projectapp.Services.TaxService;
import projectapp.Models.TaxSalaryChildModel;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/tax")
public class TaxController {
    
@Autowired
private TaxService taxService;

    @PostMapping("/calculatesalary")
    public ResponseEntity<Map<String, Object>> returnTakeHomeSalary(@RequestBody TaxSalaryChildModel taxModel) {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("Take home (yearly):", taxService.calculateTakeHomeYearlyPay(taxModel));
            response.put("Total income::", taxService.calculateTotalIncome(taxModel));
            response.put("Total deductions:", taxService.calculateTotalDeductions(taxModel));
            response.put("Student Loan deduction:", taxService.calculateStudentLoanOwed(taxModel));
            response.put("Pension deduction:", taxService.calculatePensionContribution(taxModel));
            response.put("National Insurance deduction:", taxService.calculateNationalInsuranceOwed(taxModel));
            response.put("Income tax deduction:", taxService.calculateTaxOwed(taxModel));
            return ResponseEntity.ok(response);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/calculatesalaryfromhourly")
    public ResponseEntity<Map<String, Object>> returnTakeHomeSalaryFromHourly(@RequestBody TaxHourlyChildModel taxModel) {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("Take home (yearly):", taxService.calculateTakeHomeYearlyPay(taxModel));
            response.put("Total income:", taxService.calculateTotalIncome(taxModel));
            response.put("Total deductions:", taxService.calculateTotalDeductions(taxModel));
            response.put("Student Loan deduction:", taxService.calculateStudentLoanOwed(taxModel));
            response.put("Pension deduction:", taxService.calculatePensionContribution(taxModel));
            response.put("National Insurance deduction:", taxService.calculateNationalInsuranceOwed(taxModel));
            response.put("Income tax deduction:", taxService.calculateTaxOwed(taxModel));
            return ResponseEntity.ok(response);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}

