package projectapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import projectapp.Models.MortgageModel;
import projectapp.Services.MortgageService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.HashMap;
import java.util.Map;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class MortgageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MortgageService mortgageService;

    @Autowired
    private ObjectMapper objectMapper;

@Test
void shouldReturnMonthlyRepayment() throws Exception {
    Map<String, Object> requestMap = new HashMap<>();
    requestMap.put("interestRate", 4.4);
    requestMap.put("termYears", 2);
    requestMap.put("currentEquity", 35000);
    requestMap.put("propertyValue", 220000);

    MortgageModel model = new MortgageModel(4.4, 2, 35000, 220000);
    double expectedRepayment = mortgageService.calculateMonthlyRepayment(model);

    MvcResult result = mockMvc.perform(post("/mortgage/calculate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(requestMap)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.monthlyRepayment").value(expectedRepayment))
            .andReturn();

}

@Test
void shouldReturnMonthlyRepaymentError() throws Exception {
    Map<String, Object> requestMap = new HashMap<>();
    requestMap.put("interestRate", -4.4);
    requestMap.put("termYears", 2);
    requestMap.put("currentEquity", 35000);
    requestMap.put("propertyValue", 220000);

    mockMvc.perform(post("/mortgage/calculate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(requestMap)))
            .andExpect(status().isBadRequest());
}
}