package drextar.application.controller;

import drextar.application.dto.ProductResponseDTO;
import drextar.application.service.ListProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ListProductController {

    private static final Logger logger = LoggerFactory.getLogger(ListProductController.class);

    @Autowired
    private ListProductService listProductService;

    @GetMapping("/{sellerId}/{sellerSkuId}")
    public ProductResponseDTO listProduct(
            @PathVariable String sellerId,
            @PathVariable String sellerSkuId,
            @RequestHeader("X-VTEX-API-AppKey") String appKey,
            @RequestHeader("X-VTEX-API-AppToken") String appToken
    ) {
        logger.info("List product called with sellerId: {}, sellerSkuId: {}",
                sellerId, sellerSkuId);
        return listProductService.listProduct(sellerId, sellerSkuId, appKey, appToken);
    }
}
