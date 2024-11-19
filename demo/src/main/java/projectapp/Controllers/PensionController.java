package projectapp.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import projectapp.Models.PensionModel;
import projectapp.Services.PensionService;
import java.util.Map;
import java.util.HashMap;
import java.text.DecimalFormat;


@RestController
@RequestMapping("/pension")
public class PensionController {
    @Autowired
    private PensionService pensionService;

    @PostMapping("/calculate/pot")
    public ResponseEntity<Map<String, Object>> returnTotalPot(@RequestBody PensionModel pensionModel) {
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            Map<String, Object> response = new HashMap<>();
            response.put("Total Pot", Double.valueOf(df.format(pensionService.calculateRetirementPot(pensionModel))));
        return ResponseEntity.ok(response);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/calculate/lumpsum&drawdown")
    public ResponseEntity<Map<String, Object>> returnLumpSumAndDrawdown(@RequestBody PensionModel pensionModel) {
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            Map<String, Object> response = new HashMap<>();
            response.put("Total Pot", Double.valueOf(df.format(pensionService.calculateRetirementPot(pensionModel))));
            response.put("Lump Sum", Double.valueOf(df.format(pensionService.calculateLumpSum(pensionModel))));
            response.put("Drawdown", Double.valueOf(df.format(pensionService.calculateDrawdownWithLumpSum(pensionModel))));
            response.put("Retirement length (years)", Double.valueOf(df.format(pensionService.calculateRetirementLength(pensionModel))));
        return ResponseEntity.ok(response);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/calculate/drawdown")
    public ResponseEntity<Map<String, Object>> returnDrawdown(@RequestBody PensionModel pensionModel) {
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            Map<String, Object> response = new HashMap<>();
            response.put("Total Pot", Double.valueOf(df.format(pensionService.calculateRetirementPot(pensionModel))));
            response.put("Drawdown", Double.valueOf(df.format(pensionService.calculateDrawdown(pensionModel))));
            response.put("Retirement length (years)", Double.valueOf(df.format(pensionService.calculateRetirementLength(pensionModel))));
        return ResponseEntity.ok(response);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
