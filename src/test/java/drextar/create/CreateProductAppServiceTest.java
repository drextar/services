//package drextar.create;
//
//import drextar.application.dto.ProductDTO;
//import drextar.application.service.CreateProductAppService;
//import drextar.application.service.CreateProductService;
//import drextar.domain.CreateProductDomainService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.mockito.Mockito.verify;
//
//class CreateProductAppServiceTest {
//
//    @Mock
//    private CreateProductDomainService createProductDomainService;
//
//    @InjectMocks
//    private CreateProductService createProductService;
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
//        createProductAppService.createProduct(sellerId, productId, productRequest); // Corrigido aqui
//
//        // Verifique se o método do serviço de domínio foi chamado com os parâmetros corretos
//        verify(createProductDomainService).createProduct(sellerId, productId, productRequest);
//    }
//}
