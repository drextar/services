package drextar.application.service;

import drextar.application.dto.ProductRequest;
import drextar.domain.VtexService;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final VtexService vtexService;

    public ProductService(VtexService vtexService) {
        this.vtexService = vtexService;
    }

    public void updateProduct(String sellerId, String productId, ProductRequest productRequest) {
        vtexService.updateProduct(sellerId, productId, productRequest);
    }
}
