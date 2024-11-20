package projectapp.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import projectapp.Models.StockModel;
import java.util.List;

@Service
public class StockService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey = "1TGGWQAA60RL5H44";
    private final String API_URL = "https://www.alphavantage.co/query?function=TOP_GAINERS_LOSERS&apikey=" + apiKey;

    public List<StockModel> getStockByCategory(String category) {
        try {
            String response = restTemplate.getForObject(API_URL, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response);
            JsonNode categoryNode = rootNode.path(category);
            return mapper.convertValue(categoryNode, new TypeReference<List<StockModel>>(){});
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to fetch market data", e);
        }
    }

    public List<StockModel> getTopGainers() {
        return getStockByCategory("top_gainers");
    }

    public List<StockModel> getTopLosers() {
        return getStockByCategory("top_losers");
    }

    public List<StockModel> getMostActivelyTraded() {
        return getStockByCategory("most_actively_traded");
    }
}