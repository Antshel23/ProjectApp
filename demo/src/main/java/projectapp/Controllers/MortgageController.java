package projectapp.Controllers;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projectapp.Models.MortgageModel;
import projectapp.Services.MortgageService;


@RestController
@RequestMapping("/mortgage")
public class MortgageController {
    
    @Autowired
    private MortgageService mortgageService;

    @PostMapping("/calculate")
    public ResponseEntity<MortgageModel> returnMonthlyRepayment(@RequestBody MortgageModel mortgageModel) {
        try {
        double monthlyRepayment = mortgageService.calculateMonthlyRepayment(mortgageModel);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        monthlyRepayment = Double.parseDouble(decimalFormat.format(monthlyRepayment));
        mortgageModel.setMonthlyRepayment(monthlyRepayment);
        return ResponseEntity.ok(mortgageModel);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
