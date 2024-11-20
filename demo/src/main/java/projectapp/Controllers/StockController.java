package projectapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projectapp.Models.StockModel;
import projectapp.Services.StockService;
import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/gainers")
    public List<StockModel> getTopGainers(){
        return stockService.getTopGainers();
    }

    @GetMapping("/losers")
    public List<StockModel> getTopLosers(){
        return stockService.getTopLosers();
    }

    @GetMapping("/active")
    public List<StockModel> getMostActivelyTraded(){
        return stockService.getMostActivelyTraded();
    }
}
