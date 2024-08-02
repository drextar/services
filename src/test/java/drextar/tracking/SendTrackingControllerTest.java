package drextar.tracking;

import drextar.application.controller.SendTrackingController;
import drextar.application.dto.request.sendTracking.SendTrackingRequestDTO;
import drextar.application.service.SendTrackingService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SendTrackingController.class)
public class SendTrackingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SendTrackingService sendTrackingService;

    @Test
    public void testSendTracking_Success() throws Exception {
        String requestBody = """
        {
            "courier": "courier-example",
            "trackingNumber": "12345678abc",
            "trackingUrl": "https://courier-example.com/tracking",
            "dispatchedDate": "2021-06-09"
        }
        """;

        Mockito.doNothing().when(sendTrackingService)
                .sendTracking(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.any(SendTrackingRequestDTO.class));

        mockMvc.perform(post("/orders/1448920500137-01/invoice/INV123/tracking")
                        .header("X-VTEX-API-AppKey", "vtexappkey-itaudemo-DTISMM")
                        .header("X-VTEX-API-AppToken", "GZVRBNKDKTUWBBJSRIQBSRRBMGRXPWJIEABWUOHPHCRNPJPXUBMKBKPUMETMXBMTUTYDSXUNVZYQJDQVBNFOAWGLZGPSDVVBHXALUMYIAZUTCLBIYPAUHZTJOZHTPFVO")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void testSendTracking_MissingHeader() throws Exception {
        String requestBody = """
        {
            "courier": "courier-example",
            "trackingNumber": "12345678abc",
            "trackingUrl": "https://courier-example.com/tracking",
            "dispatchedDate": "2021-06-09"
        }
        """;

        mockMvc.perform(post("/orders/1448920500137-01/invoice/INV123/tracking")
                        .header("X-VTEX-API-AppKey", "vtexappkey-itaudemo-DTISMM")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testSendTracking_InvalidRequest() throws Exception {
        String invalidRequestBody = """
    {
        "courier": "",
        "trackingNumber": "12345678abc",
        "trackingUrl": "",
        "dispatchedDate": ""
    }
    """;

        mockMvc.perform(post("/orders/1448920500137-01/invoice/INV123/tracking")
                        .header("X-VTEX-API-AppKey", "vtexappkey-itaudemo-DTISMM")
                        .header("X-VTEX-API-AppToken", "GZVRBNKDKTUWBBJSRIQBSRRBMGRXPWJIEABWUOHPHCRNPJPXUBMKBKPUMETMXBMTUTYDSXUNVZYQJDQVBNFOAWGLZGPSDVVBHXALUMYIAZUTCLBIYPAUHZTJOZHTPFVO")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidRequestBody))
                .andExpect(status().isBadRequest());
    }
}
