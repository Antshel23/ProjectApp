package projectapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projectapp.Models.MortgageModel;
import projectapp.Services.MortgageService;
import projectapp.Services.MortgageService;


@RestController
@RequestMapping("/mortgage")
public class MortgageController {
    
    @Autowired
    private MortgageService mortgageService;

    @PostMapping("/calculate")
    public ResponseEntity<MortgageModel> recieveMortgageParams(@RequestBody MortgageModel mortgageModel) {
        try {
        double monthlyRepayment = mortgageService.calculateMonthlyRepayment(mortgageModel);
        mortgageModel.setMonthlyRepayment(monthlyRepayment);
        return ResponseEntity.ok(mortgageModel);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

}
