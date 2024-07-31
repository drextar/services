package drextar.application.service.impl;

import drextar.application.dto.request.ProductRequestDTO;
import drextar.application.service.CreateProductService;
import drextar.infrastructure.feign.CreateProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductServiceImpl implements CreateProductService {

    @Autowired
    private CreateProductClient productClient;

    @Override
    public void createProduct(String accountName, String sellerId, String sellerSkuId, String appKey, String appToken, ProductRequestDTO productRequestDTO) {
        productClient.createProduct(accountName, sellerId, sellerSkuId, appKey, appToken, productRequestDTO);
    }
}
