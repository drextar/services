package drextar.create;
import drextar.application.dto.CreateProductRequest;
import drextar.domain.CreateProductDomainService;
import drextar.infrastructure.CreateProductClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

class CreateProductDomainServiceTest {

    @Mock
    private CreateProductClient createProductClient;

    @InjectMocks
    private CreateProductDomainService createProductDomainService;

    @Value("${vtex.api.appKey}")
    private String appKey;

    @Value("${vtex.api.appToken}")
    private String appToken;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProduct() {
        String sellerId = "geantech";
        String productId = "1";
        CreateProductRequest productRequest = new CreateProductRequest(); // Popule o ProductRequest com dados de exemplo

        createProductDomainService.createProduct(sellerId, productId, productRequest);

        // Verifique se o método do cliente foi chamado com os parâmetros corretos
        verify(createProductClient).createProduct(
                appKey,
                appToken,
                sellerId,
                productId,
                productRequest
        );
    }
}