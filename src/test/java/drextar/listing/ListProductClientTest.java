package drextar.listing;

import drextar.application.dto.ProductResponseDTO;
import drextar.infrastructure.feign.ListProductClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;

@SpringBootTest
public class ListProductClientTest {

    @MockBean
    private ListProductClient listProductClient;

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

        // Chamando o método do Feign Client
        ProductResponseDTO result = listProductClient.listProduct("geantech", "1", "appKey", "appToken");

        // Verificando se o resultado é o esperado
        assertEquals(productResponseDTO, result);

        // Verificando se o método do Feign Client foi chamado corretamente
        verify(listProductClient, times(1)).listProduct(
                eq("geantech"), eq("1"), eq("appKey"), eq("appToken"));
    }

    @Test
    void testListProductThrowsException() {
        // Configurando o mock para lançar uma exceção quando o Feign Client for chamado
        doThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"))
                .when(listProductClient).listProduct(any(String.class), any(String.class), any(String.class), any(String.class));

        // Chamando o método do Feign Client, esperando que uma exceção seja lançada
        try {
            listProductClient.listProduct("geantech", "1", "appKey", "appToken");
        } catch (ResponseStatusException ex) {
            // Verificando se a exceção é do tipo esperado
            assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
        }
    }
}
