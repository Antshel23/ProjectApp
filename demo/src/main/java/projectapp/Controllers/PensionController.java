package projectapp.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projectapp.Models.MortgageModel;
import projectapp.Models.PensionModel;
import projectapp.Services.MortgageService;
import projectapp.Services.PensionService;


@RestController
@RequestMapping("/pension")
public class PensionController {
    @Autowired
    private PensionService pensionService;

    @PostMapping("/calculate/pot")
    public ResponseEntity<PensionModel> returnX(@RequestBody PensionModel pensionModel) {
        try {
        return ResponseEntity.ok(pensionModel);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @PostMapping("/calculate/lumpsum&drawdown")
    public ResponseEntity<PensionModel> returnY(@RequestBody PensionModel pensionModel) {
        try {
        return ResponseEntity.ok(pensionModel);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @PostMapping("/calculate/drawdown")
    public ResponseEntity<PensionModel> returnZ(@RequestBody PensionModel pensionModel) {
        try {
        return ResponseEntity.ok(pensionModel);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }

    }
}
