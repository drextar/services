package drextar.application.service;

import drextar.application.dto.ProductRequestDTO;

public interface CreateProductService {
    void createProduct(String accountName, String sellerId, String sellerSkuId, String appKey, String appToken, ProductRequestDTO productRequestDTO);
}
