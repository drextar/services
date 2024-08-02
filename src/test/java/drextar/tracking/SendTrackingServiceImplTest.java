package drextar.tracking;

import drextar.application.dto.request.sendTracking.SendTrackingRequestDTO;
import drextar.application.service.impl.SendTrackingServiceImpl;
import drextar.infrastructure.feign.SendTrackingClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class SendTrackingServiceImplTest {

    @Mock
    private SendTrackingClient sendTrackingClient;

    @InjectMocks
    private SendTrackingServiceImpl sendTrackingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendTracking() {
        // Given
        String marketplaceOrderId = "1448920500137-01";
        String invoiceNumber = "INV123";
        String appKey = "vtexappkey-itaudemo-DTISMM";
        String appToken = "GZVRBNKDKTUWBBJSRIQBSRRBMGRXPWJIEABWUOHPHCRNPJPXUBMKBKPUMETMXBMTUTYDSXUNVZYQJDQVBNFOAWGLZGPSDVVBHXALUMYIAZUTCLBIYPAUHZTJOZHTPFVO";
        SendTrackingRequestDTO requestDTO = new SendTrackingRequestDTO();
        requestDTO.setCourier("courier-example");
        requestDTO.setTrackingNumber("12345678abc");
        requestDTO.setTrackingUrl("https://courier-example.com/tracking");
        requestDTO.setDispatchedDate("2021-06-09");

        // When
        sendTrackingService.sendTracking(marketplaceOrderId, invoiceNumber, appKey, appToken, requestDTO);

        // Then
        verify(sendTrackingClient, times(1)).sendTracking(marketplaceOrderId, invoiceNumber, appKey, appToken, requestDTO);
    }
}

