package drextar.infrastructure.feign;

import drextar.application.config.FeignConfig;
import drextar.application.dto.ProductResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "listingProductClient", url = "https://itaudemo.vtexcommercestable.com.br", configuration = FeignConfig.class)
public interface ListProductClient {

    @GetMapping("/api/catalog_system/pvt/skuseller/{sellerId}/{sellerSkuId}")
    ProductResponseDTO listProduct(
            @PathVariable("sellerId") String sellerId,
            @PathVariable("sellerSkuId") String sellerSkuId,
            @RequestHeader("X-VTEX-API-AppKey") String appKey,
            @RequestHeader("X-VTEX-API-AppToken") String appToken
    );

}