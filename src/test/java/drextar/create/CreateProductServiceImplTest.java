package drextar.create;

import drextar.application.dto.request.ProductRequestDTO;
import drextar.application.service.impl.CreateProductServiceImpl;
import drextar.infrastructure.feign.CreateProductClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CreateProductServiceImplTest {

    @Mock
    private CreateProductClient productClient;

    @InjectMocks
    private CreateProductServiceImpl createProductService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProduct() {
        // Simulando os dados de entrada
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductId("1");
        productRequestDTO.setProductName("Product Test");

        // Chamando o método do serviço
        createProductService.createProduct("itaudemo", "geantech", "1", "appKey", "appToken", productRequestDTO);

        // Verificando se o método do cliente Feign foi chamado corretamente
        verify(productClient, times(1)).createProduct(
                eq("itaudemo"), eq("geantech"), eq("1"), eq("appKey"), eq("appToken"), any(ProductRequestDTO.class));
    }
}
