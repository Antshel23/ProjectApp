package projectapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.closeTo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import projectapp.Models.TaxSalaryChildModel;
import projectapp.Models.TaxHourlyChildModel;
import projectapp.Models.TaxModel;
import projectapp.Services.TaxService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.mock.mockito.MockBean;

class TaxControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TaxService taxService;
    @Test
    void shouldReturnCorrectValuesForSalaryModel() throws Exception {

        TaxModel taxModel = new TaxSalaryChildModel(50000, 1, 5000, 2000);
        String requestBody = objectMapper.writeValueAsString(taxModel);

        double expectedTakeHomeYearly = taxService.calculateTakeHomeYearlyPay(taxModel);
        double expectedTotalIncome = taxService.calculateTotalIncome(taxModel);
        double expectedTotalDeductions = taxService.calculateTotalDeductions(taxModel);
        double expectedStudentLoanOwed = taxService.calculateStudentLoanOwed(taxModel);
        double expectedPensionContribution = taxService.calculatePensionContribution(taxModel);
        double expectedNationalInsuranceOwed = taxService.calculateNationalInsuranceOwed(taxModel);
        double expectedTaxOwed = taxService.calculateTaxOwed(taxModel);

                mockMvc.perform(post("/tax/calculate/takehome/salary")
                .contentType("application/json")
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.['Take home (yearly)']").value(closeTo(expectedTakeHomeYearly, 0.01)))
                .andExpect(jsonPath("$.['Total income']").value(closeTo(expectedTotalIncome, 0.01)))
                .andExpect(jsonPath("$.['Total deductions']").value(closeTo(expectedTotalDeductions, 0.01)))
                .andExpect(jsonPath("$.['Student Loan deduction']").value(closeTo(expectedStudentLoanOwed, 0.01)))
                .andExpect(jsonPath("$.['Pension deduction']").value(closeTo(expectedPensionContribution, 0.01)))
                .andExpect(jsonPath("$.['National Insurance deduction']").value(closeTo(expectedNationalInsuranceOwed, 0.01)))
                .andExpect(jsonPath("$.['Income tax deduction']").value(closeTo(expectedTaxOwed, 0.01)));
    }

    @Test
    void shouldReturnCorrectValuesForHourlyModel() throws Exception {

        TaxModel taxModel = new TaxHourlyChildModel(15,37, 1, 4000, 2000);
        taxModel.getBaseSalary();
        String requestBody = objectMapper.writeValueAsString(taxModel);

        double expectedTakeHomeYearly = taxService.calculateTakeHomeYearlyPay(taxModel);
        double expectedTotalIncome = taxService.calculateTotalIncome(taxModel);
        double expectedTotalDeductions = taxService.calculateTotalDeductions(taxModel);
        double expectedStudentLoanOwed = taxService.calculateStudentLoanOwed(taxModel);
        double expectedPensionContribution = taxService.calculatePensionContribution(taxModel);
        double expectedNationalInsuranceOwed = taxService.calculateNationalInsuranceOwed(taxModel);
        double expectedTaxOwed = taxService.calculateTaxOwed(taxModel);

                mockMvc.perform(post("/tax/calculate/takehome/salary")
                .contentType("application/json")
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.['Take home (yearly)']").value(closeTo(expectedTakeHomeYearly, 0.01)))
                .andExpect(jsonPath("$.['Total income']").value(closeTo(expectedTotalIncome, 0.01)))
                .andExpect(jsonPath("$.['Total deductions']").value(closeTo(expectedTotalDeductions, 0.01)))
                .andExpect(jsonPath("$.['Student Loan deduction']").value(closeTo(expectedStudentLoanOwed, 0.01)))
                .andExpect(jsonPath("$.['Pension deduction']").value(closeTo(expectedPensionContribution, 0.01)))
                .andExpect(jsonPath("$.['National Insurance deduction']").value(closeTo(expectedNationalInsuranceOwed, 0.01)))
                .andExpect(jsonPath("$.['Income tax deduction']").value(closeTo(expectedTaxOwed, 0.01)));
    }
}