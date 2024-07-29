package drextar.application.service;

import drextar.application.dto.ProductResponseDTO;

public interface ListProductService {
    ProductResponseDTO listProduct(String sellerId, String sellerSkuId, String appKey, String appToken);
}