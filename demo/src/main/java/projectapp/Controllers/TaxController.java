package projectapp.Controllers;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projectapp.Models.TaxHourlyChildModel;
import projectapp.Models.TaxModel;
//import projectapp.Services.TaxService;
import projectapp.Models.TaxSalaryChildModel;


@RestController
@RequestMapping("/tax")
public class TaxController {
    
    //@Autowired
    //private TaxService taxService;

    @PostMapping("/calculatesalary")
    public ResponseEntity<TaxModel> calculateSalaryTakeHome(@RequestBody TaxSalaryChildModel taxModel) {
        try {
            return ResponseEntity.ok(taxModel);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
        @PostMapping("/calculatehourly")
        public ResponseEntity<TaxModel> calculateHourlyTakeHome(@RequestBody TaxHourlyChildModel taxModel) {
            try {
                return ResponseEntity.ok(taxModel);
            }
            catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(null);
            }
    }

}

