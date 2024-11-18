package projectapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectapp.Models.TaxModel;
import projectapp.Services.TaxService;


@RestController
@RequestMapping("/tax")
public class TaxController {
    
    @Autowired
    private TaxService taxService;

    @PostMapping("/calculate")
    public ResponseEntity<TaxModel> recieveMortgageParams(@RequestBody TaxModel taxModel) {
        try {
            return ResponseEntity.ok(taxModel);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

}
