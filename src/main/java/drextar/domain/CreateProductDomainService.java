package drextar.domain;

import drextar.application.dto.CreateProductRequest;
import drextar.infrastructure.CreateProductClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CreateProductDomainService {

    private final CreateProductClient createProductClient;
    private final String appKey;
    private final String appToken;

    public CreateProductDomainService(CreateProductClient createProductClient,
                                      @Value("${vtex.api.appKey}") String appKey,
                                      @Value("${vtex.api.appToken}") String appToken) {
        this.createProductClient = createProductClient;
        this.appKey = appKey;
        this.appToken = appToken;
    }

    public void createProduct(String sellerId, String productId, CreateProductRequest createProductRequest) {
        createProductClient.createProduct(appKey, appToken, sellerId, productId, createProductRequest);
    }
}
