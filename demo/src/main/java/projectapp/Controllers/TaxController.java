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
import java.util.LinkedHashMap;
import java.text.DecimalFormat;


@RestController
@RequestMapping("/tax")
public class TaxController {
    
@Autowired
private TaxService taxService;

    @PostMapping("/calculate/takehome/salary")
    public ResponseEntity<Map<String, Object>> returnTakeHomeSalary(@RequestBody TaxSalaryChildModel taxModel) {
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("Take home (yearly)", Double.valueOf(df.format(taxService.calculateTakeHomeYearlyPay(taxModel))));
            response.put("Total income", Double.valueOf(df.format(taxService.calculateTotalIncome(taxModel))));
            response.put("Total deductions", Double.valueOf(df.format(taxService.calculateTotalDeductions(taxModel))));
            response.put("Student Loan deduction", Double.valueOf(df.format(taxService.calculateStudentLoanOwed(taxModel))));
            response.put("Pension deduction", Double.valueOf(df.format(taxService.calculatePensionContribution(taxModel))));
            response.put("National Insurance deduction", Double.valueOf(df.format(taxService.calculateNationalInsuranceOwed(taxModel))));
            response.put("Income tax deduction", Double.valueOf(df.format(taxService.calculateTaxOwed(taxModel))));
            return ResponseEntity.ok(response);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/calculate/takehome/hourly")
    public ResponseEntity<Map<String, Object>> returnTakeHomeSalaryFromHourly(@RequestBody TaxHourlyChildModel taxModel) {
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("Take home (yearly)", Double.valueOf(df.format(taxService.calculateTakeHomeYearlyPay(taxModel))));
            response.put("Total income", Double.valueOf(df.format(taxService.calculateTotalIncome(taxModel))));
            response.put("Total deductions", Double.valueOf(df.format(taxService.calculateTotalDeductions(taxModel))));
            response.put("Student Loan deduction", Double.valueOf(df.format(taxService.calculateStudentLoanOwed(taxModel))));
            response.put("Pension deduction", Double.valueOf(df.format(taxService.calculatePensionContribution(taxModel))));
            response.put("National Insurance deduction", Double.valueOf(df.format(taxService.calculateNationalInsuranceOwed(taxModel))));
            response.put("Income tax deduction", Double.valueOf(df.format(taxService.calculateTaxOwed(taxModel))));
            return ResponseEntity.ok(response);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}

