//package drextar.listing;
//
//import drextar.domain.ListingProductDomainService;
//import drextar.infrastructure.feign.ListingProductClient;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//class ListingProductDomainServiceTest {
//
//    @Mock
//    private ListingProductClient listingProductClient;
//
//    @InjectMocks
//    private ListingProductDomainService listingProductDomainService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void getProduct() {
//        String sellerId = "geantech";
//        String skuId = "1";
//        String appKey = "vtexappkey-itaudemo-DTISMM";
//        String appToken = "GZVRBNKDKTUWBBJSRIQBSRRBMGRXPWJIEABWUOHPHCRNPJPXUBMKBKPUMETMXBMTUTYDSXUNVZYQJDQVBNFOAWGLZGPSDVVBHXALUMYIAZUTCLBIYPAUHZTJOZHTPFVO";
//        Object expectedResponse = new Object(); // Substitua pelo objeto esperado
//
//        when(listingProductClient.getProduct(appKey, appToken, sellerId, skuId)).thenReturn(expectedResponse);
//
//        System.out.println("Mock behavior set up complete. Executing service method...");
//
//        Object actualResponse = listingProductDomainService.getProduct(sellerId, skuId);
//
//        // Debugging step: ensure that the actual response is as expected
//        System.out.println("Expected response: " + expectedResponse);
//        System.out.println("Actual response: " + actualResponse);
//
////        assertEquals(expectedResponse, actualResponse);
//    }
//}