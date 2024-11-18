package projectapp.Controllers;

import org.springframework.http.ResponseEntity;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projectapp.Models.MortgageModel;
// import projectapp.Services.MortgageService;


@RestController
@RequestMapping("/mortgage")
public class MortgageController {
    
   // @Autowired
    // private MortgageService mortgageService;

    @PostMapping("/recieve")
    public ResponseEntity<MortgageModel> recieveMortgageParams(@RequestBody MortgageModel mortgageModel) {
        return ResponseEntity.ok(mortgageModel);
    }
}
