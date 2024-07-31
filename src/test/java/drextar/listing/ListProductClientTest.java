package drextar.listing;

import drextar.application.dto.ProductResponseDTO;
import drextar.infrastructure.feign.ListProductClient;
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
public class ListProductClientTest {

    @MockBean
    private ListProductClient listProductClient;

    @Test
    void testListProduct() {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setSkuSellerId(799);
        productResponseDTO.setSellerId("geantech");
        productResponseDTO.setStockKeepingUnitId(1);

        when(listProductClient.listProduct(any(String.class), any(String.class), any(String.class), any(String.class)))
                .thenReturn(productResponseDTO);

        ProductResponseDTO result = listProductClient.listProduct("geantech", "1", "appKey", "appToken");

        assertEquals(productResponseDTO, result);

        verify(listProductClient, times(1)).listProduct(
                eq("geantech"), eq("1"), eq("appKey"), eq("appToken"));
    }

    @Test
    void testListProductThrowsException() {
        doThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"))
                .when(listProductClient).listProduct(any(String.class), any(String.class), any(String.class), any(String.class));

        try {
            listProductClient.listProduct("geantech", "1", "appKey", "appToken");
        } catch (ResponseStatusException ex) {
            assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
        }
    }
}
