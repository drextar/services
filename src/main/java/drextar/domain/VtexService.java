package drextar.domain;

import drextar.application.dto.ProductRequest;
import drextar.infrastructure.UpdateProductClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VtexService {

    private final UpdateProductClient updateProductClient;
    private final String appKey;
    private final String appToken;

    public VtexService(UpdateProductClient updateProductClient,
                       @Value("${vtex.api.appKey}") String appKey,
                       @Value("${vtex.api.appToken}") String appToken) {
        this.updateProductClient = updateProductClient;
        this.appKey = appKey;
        this.appToken = appToken;
    }

    public void updateProduct(String sellerId, String productId, ProductRequest productRequest) {
        updateProductClient.updateProduct(appKey, appToken, sellerId, productId, productRequest);
    }
}
