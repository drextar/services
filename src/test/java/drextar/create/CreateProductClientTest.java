package drextar.create;

import drextar.application.dto.request.createProduct.ProductRequestDTO;
import drextar.infrastructure.feign.CreateProductClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CreateProductClientTest {

    @MockBean
    private CreateProductClient createProductClient;

    @Test
    void testCreateProduct() {
        // Simulando os dados de entrada
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductId("1");
        productRequestDTO.setProductName("Product Test");

        // Chamando o método do Feign Client
        createProductClient.createProduct("itaudemo", "geantech", "1", "appKey", "appToken", productRequestDTO);

        // Verificando se o método do Feign Client foi chamado corretamente
        verify(createProductClient, times(1)).createProduct(
                eq("itaudemo"), eq("geantech"), eq("1"), eq("appKey"), eq("appToken"), eq(productRequestDTO));
    }

    @Test
    void testCreateProductThrowsException() {
        // Simulando os dados de entrada
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductId("1");
        productRequestDTO.setProductName("Product Test");

        // Configurando o mock para lançar uma exceção quando o Feign Client for chamado
        doThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request"))
                .when(createProductClient).createProduct(any(String.class), any(String.class), any(String.class), any(String.class), any(String.class), any(ProductRequestDTO.class));

        // Chamando o método do Feign Client, esperando que uma exceção seja lançada
        try {
            createProductClient.createProduct("itaudemo", "geantech", "1", "appKey", "appToken", productRequestDTO);
        } catch (ResponseStatusException ex) {
            // Verificando se a exceção é do tipo esperado
            assertEquals(HttpStatus.BAD_REQUEST, ex.getStatusCode());
        }
    }
}
