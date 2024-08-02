package drextar.create;

import drextar.application.controller.CreateProductController;
import drextar.application.dto.request.createProduct.ProductRequestDTO;
import drextar.application.service.CreateProductService;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CreateProductControllerTest {

    @Mock
    private CreateProductService createProductService;

    @InjectMocks
    private CreateProductController createProductController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(createProductController).build();
    }

    @Test
    void testCreateProduct() throws Exception {
        // Simulando os dados da requisição
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductId("1");
        productRequestDTO.setProductName("Product Test");

        String productRequestJson = "{ \"productId\": \"1\", \"productName\": \"Product Test\" }";

        // Configurando o mock do serviço para verificar a chamada
        mockMvc.perform(put("/products/itaudemo/geantech/1")
                        .header("X-VTEX-API-AppKey", "appKey")
                        .header("X-VTEX-API-AppToken", "appToken")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productRequestJson))
                .andExpect(status().isOk());

        // Verificando se o serviço foi chamado corretamente
        verify(createProductService, times(1)).createProduct(
                eq("itaudemo"), eq("geantech"), eq("1"), eq("appKey"), eq("appToken"), any(ProductRequestDTO.class));
    }
}
