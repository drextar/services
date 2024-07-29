//package drextar.create;
//
//import drextar.application.controller.CreateProductController;
//import drextar.application.dto.ProductDTO;
//import drextar.application.service.CreateProductAppService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//
//class CreateProductControllerTest {
//
//    @Mock
//    private CreateProductAppService createProductService;
//
//    @InjectMocks
//    private CreateProductController createProductController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void createProduct() {
//        String sellerId = "geantech";
//        String productId = "1";
//        ProductDTO productRequest = new ProductDTO(); // Popule o ProductRequest com dados de exemplo
//
//        ResponseEntity<Void> responseEntity = createProductController.createProduct(sellerId, productId, productRequest);
//
//        // Verifique se o método do serviço foi chamado com os parâmetros corretos
//        verify(createProductService).createProduct(sellerId, productId, productRequest);
//
//        // Verifique se a resposta é a esperada
//        assertEquals(ResponseEntity.ok().build(), responseEntity);
//    }
//}
