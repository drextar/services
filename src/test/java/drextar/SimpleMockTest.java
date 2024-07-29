//package drextar;
//
//import drextar.infrastructure.feign.ListingProductClient;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.MockitoAnnotations;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//class SimpleMockTest {
//
//    private ListingProductClient listingProductClient;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        listingProductClient = mock(ListingProductClient.class);
//    }
//
//    @Test
//    void testMockBehavior() {
//        String sellerId = "geantech";
//        String skuId = "1";
//        String appKey = "vtexappkey-itaudemo-DTISMM";
//        String appToken = "GZVRBNKDKTUWBBJSRIQBSRRBMGRXPWJIEABWUOHPHCRNPJPXUBMKBKPUMETMXBMTUTYDSXUNVZYQJDQVBNFOAWGLZGPSDVVBHXALUMYIAZUTCLBIYPAUHZTJOZHTPFVO";
//        Object expectedResponse = new Object(); // Substitua pelo objeto esperado
//
//        // Configurando o comportamento do mock
//        when(listingProductClient.getProduct(appKey, appToken, sellerId, skuId)).thenReturn(expectedResponse);
//
//        // Verificando se o mock retorna o valor esperado
//        Object actualResponse = listingProductClient.getProduct(appKey, appToken, sellerId, skuId);
//
//        assertEquals(expectedResponse, actualResponse);
//    }
//}
