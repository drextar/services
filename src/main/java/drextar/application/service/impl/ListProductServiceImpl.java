package drextar.application.service.impl;

import drextar.application.dto.ProductResponseDTO;
import drextar.application.service.ListProductService;
import drextar.infrastructure.feign.ListProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListProductServiceImpl implements ListProductService {

    private static final Logger logger = LoggerFactory.getLogger(ListProductServiceImpl.class);

    @Autowired
    private ListProductClient listProductClient;

    @Override
    public ProductResponseDTO listProduct(String sellerId, String sellerSkuId, String appKey, String appToken) {
        logger.info("Calling VTEX client with sellerId: {}, sellerSkuId: {}",
                sellerId, sellerSkuId);

        return listProductClient.listProduct(sellerId, sellerSkuId, appKey, appToken);
    }

}
