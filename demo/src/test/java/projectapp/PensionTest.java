package projectapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import projectapp.Models.PensionModel;
import projectapp.Services.PensionService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.closeTo;
import java.util.HashMap;
import java.util.Map;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class PensionTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PensionService pensionService;

    @Autowired
    private ObjectMapper objectMapper;

@Test
void shouldReturnTotalPot() throws Exception {
    Map<String, Object> requestMap = new HashMap<>();
    requestMap.put("totalAnnualIncome", 41400);
    requestMap.put("personalContribution",0);
    requestMap.put("employerContribution", 12);
    requestMap.put("currentPot", 6000);
    requestMap.put("age", 22);
    requestMap.put("retirementAge", 65);

    PensionModel model = new PensionModel(41400,0,12,6000,22,65);
    double expectedPot = pensionService.calculateRetirementPot(model);
    double tolerance = 0.01;

   mockMvc.perform(post("/pension/calculate/pot")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(requestMap)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.totalPot", closeTo(expectedPot, tolerance)));
}

@Test
void shouldReturnTotalPotError() throws Exception {
    Map<String, Object> requestMap = new HashMap<>();
    requestMap.put("totalAnnualIncome", 41400);
    requestMap.put("personalContribution",0);
    requestMap.put("employerContribution", 12);
    requestMap.put("currentPot", 6000);
    requestMap.put("age", 22);
    requestMap.put("retirementAge", 20);

    mockMvc.perform(post("/pension/calculate/pot")
    .contentType(MediaType.APPLICATION_JSON)
    .content(objectMapper.writeValueAsString(requestMap)))
            .andExpect(status().isBadRequest());
}
}

