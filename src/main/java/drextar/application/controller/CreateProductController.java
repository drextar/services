package drextar.application.controller;

import drextar.application.dto.request.ProductRequestDTO;
import drextar.application.service.CreateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class CreateProductController {

    @Autowired
    private CreateProductService createProductService;

    @PutMapping("/{accountName}/{sellerId}/{sellerSkuId}")
    public void createProduct(
            @PathVariable String accountName,
            @PathVariable String sellerId,
            @PathVariable String sellerSkuId,
            @RequestHeader("X-VTEX-API-AppKey") String appKey,
            @RequestHeader("X-VTEX-API-AppToken") String appToken,
            @RequestBody ProductRequestDTO productRequestDTO
    ) {
        createProductService.createProduct(accountName, sellerId, sellerSkuId, appKey, appToken, productRequestDTO);
    }
}
