package drextar.create;

import drextar.application.dto.CreateProductRequest;
import drextar.application.service.CreateProductAppService;
import drextar.domain.CreateProductDomainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class CreateProductAppServiceTest {

    @Mock
    private CreateProductDomainService createProductDomainService;

    @InjectMocks
    private CreateProductAppService createProductAppService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProduct() {
        String sellerId = "geantech";
        String productId = "1";
        CreateProductRequest productRequest = new CreateProductRequest(); // Popule o ProductRequest com dados de exemplo

        createProductAppService.createProduct(sellerId, productId, productRequest); // Corrigido aqui

        // Verifique se o método do serviço de domínio foi chamado com os parâmetros corretos
        verify(createProductDomainService).createProduct(sellerId, productId, productRequest);
    }
}
