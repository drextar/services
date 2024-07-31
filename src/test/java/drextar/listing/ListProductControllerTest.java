package drextar.listing;

import drextar.application.controller.ListProductController;
import drextar.application.dto.ProductResponseDTO;
import drextar.application.service.ListProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ListProductControllerTest {

    @Mock
    private ListProductService listProductService;

    @InjectMocks
    private ListProductController listProductController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(listProductController).build();
    }

    @Test
    void testListProduct() throws Exception {
        // Simulando a resposta do serviço
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setSkuSellerId(799);
        productResponseDTO.setSellerId("geantech");
        productResponseDTO.setStockKeepingUnitId(1);

        when(listProductService.listProduct(any(String.class), any(String.class), any(String.class), any(String.class)))
                .thenReturn(productResponseDTO);

        mockMvc.perform(get("/products/geantech/1")
                        .header("X-VTEX-API-AppKey", "appKey")
                        .header("X-VTEX-API-AppToken", "appToken")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.skuSellerId").value(799))
                .andExpect(jsonPath("$.sellerId").value("geantech"))
                .andExpect(jsonPath("$.stockKeepingUnitId").value(1));

        verify(listProductService).listProduct(
                eq("geantech"), eq("1"), eq("appKey"), eq("appToken"));
    }
}