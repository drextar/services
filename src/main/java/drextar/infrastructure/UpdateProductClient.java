package drextar.infrastructure;

import drextar.application.dto.ProductRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "vtexClient", url = "https://api.vtex.com/itaudemo")
public interface UpdateProductClient {

    @PutMapping("/suggestions/{sellerId}/{productId}")
    void updateProduct(
            @RequestHeader("X-VTEX-API-AppKey") String appKey,
            @RequestHeader("X-VTEX-API-AppToken") String appToken,
            @PathVariable("sellerId") String sellerId,
            @PathVariable("productId") String productId,
            @RequestBody ProductRequest productRequest
    );
}