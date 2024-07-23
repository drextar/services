package drextar.application.service;

import drextar.application.dto.CreateProductRequest;
import drextar.domain.CreateProductDomainService;
import org.springframework.stereotype.Service;

@Service
public class CreateProductAppService {

    private final CreateProductDomainService createProductDomainService;

    public CreateProductAppService(CreateProductDomainService createProductDomainService) {
        this.createProductDomainService = createProductDomainService;
    }

    public void createProduct(String sellerId, String productId, CreateProductRequest createProductRequest) {
        createProductDomainService.createProduct(sellerId, productId, createProductRequest);
    }
}
