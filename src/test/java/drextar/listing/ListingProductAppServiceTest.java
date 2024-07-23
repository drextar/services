package drextar.listing;

import drextar.application.service.ListingProductAppService;
import drextar.domain.ListingProductDomainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ListingProductAppServiceTest {

    @Mock
    private ListingProductDomainService listingProductDomainService;

    @InjectMocks
    private ListingProductAppService listingProductAppService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getProduct() {
        String sellerId = "geantech";
        String skuId = "1";
        Object expectedResponse = new Object(); // Substitua pelo objeto esperado

        // Configurar comportamento do mock
        when(listingProductDomainService.getProduct(sellerId, skuId)).thenReturn(expectedResponse);

        // Executar o método e verificar o resultado
        Object actualResponse = listingProductAppService.getProduct(sellerId, skuId);

        // Verificar se o resultado é o esperado
        assertEquals(expectedResponse, actualResponse);
    }
}
