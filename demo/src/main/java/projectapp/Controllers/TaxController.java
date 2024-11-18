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
            response.put("Yearly:", taxService.calculateTakeHomeYearlyPay(taxModel));
            response.put("Monthly:", taxService.calculateTakeHomeMonthlyPay(taxModel));
            response.put("Student loan deduction:", taxService.calculateStudentLoanOwed(taxModel));
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
            response.put("Yearly:", taxService.calculateTakeHomeYearlyPay(taxModel));
            response.put("Monthly:", taxService.calculateTakeHomeMonthlyPay(taxModel));
            response.put("Student loan deduction:", taxService.calculateStudentLoanOwed(taxModel));
            return ResponseEntity.ok(response);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}

