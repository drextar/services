package drextar.listing;

import drextar.application.dto.ProductResponseDTO;
import drextar.application.service.impl.ListProductServiceImpl;
import drextar.infrastructure.feign.ListProductClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListProductServiceImplTest {

    @Mock
    private ListProductClient listProductClient;

    @InjectMocks
    private ListProductServiceImpl listProductService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListProduct() {
        // Simulando a resposta do cliente Feign
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setSkuSellerId(799);
        productResponseDTO.setSellerId("geantech");
        productResponseDTO.setStockKeepingUnitId(1);

        // Configurando o mock do cliente Feign para retornar o DTO simulado
        when(listProductClient.listProduct(any(String.class), any(String.class), any(String.class), any(String.class)))
                .thenReturn(productResponseDTO);

        // Chamando o método do serviço
        ProductResponseDTO result = listProductService.listProduct("geantech", "1", "appKey", "appToken");

        // Verificando se o resultado é o esperado
        assertEquals(productResponseDTO, result);

        // Verificando se o método do cliente Feign foi chamado corretamente
        verify(listProductClient).listProduct(
                eq("geantech"), eq("1"), eq("appKey"), eq("appToken"));
    }
}
