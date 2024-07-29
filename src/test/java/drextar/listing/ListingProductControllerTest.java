//package drextar.listing;
//
//import drextar.application.controller.ListingProductController;
//import drextar.application.service.ListingProductAppService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//class ListingProductControllerTest {
//
//    @Mock
//    private ListingProductAppService listingProductAppService;
//
//    @InjectMocks
//    private ListingProductController listingProductController;
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
//        Object expectedResponse = new Object(); // Substitua pelo objeto esperado
//
//        // Configurar comportamento do mock
//        when(listingProductAppService.getProduct(sellerId, skuId)).thenReturn(expectedResponse);
//
//        // Executar o método e verificar o resultado
//        ResponseEntity<Object> responseEntity = listingProductController.getProduct(sellerId, skuId);
//
//        // Verificar se o resultado é o esperado
//        assertEquals(ResponseEntity.ok(expectedResponse), responseEntity);
//    }
//}
