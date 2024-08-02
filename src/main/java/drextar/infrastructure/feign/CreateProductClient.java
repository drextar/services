package drextar.infrastructure.feign;

import drextar.application.config.FeignConfig;
import drextar.application.dto.request.createProduct.ProductRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "vtexClient", url = "https://api.vtex.com",  configuration = FeignConfig.class)
public interface CreateProductClient {

    @PutMapping("/{accountName}/suggestions/{sellerId}/{sellerSkuId}")
    void createProduct(
            @PathVariable("accountName") String accountName,
            @PathVariable("sellerId") String sellerId,
            @PathVariable("sellerSkuId") String sellerSkuId,
            @RequestHeader("X-VTEX-API-AppKey") String appKey,
            @RequestHeader("X-VTEX-API-AppToken") String appToken,
            @RequestBody ProductRequestDTO product
    );
}