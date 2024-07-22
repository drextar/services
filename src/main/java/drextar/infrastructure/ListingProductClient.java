package drextar.infrastructure;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "productListingClient", url = "https://itaudemo.vtexcommercestable.com.br")
public interface ListingProductClient {

    @GetMapping("/api/catalog_system/pvt/skuseller/{sellerId}/{skuId}")
    Object getProduct(
            @RequestHeader("X-VTEX-API-AppKey") String appKey,
            @RequestHeader("X-VTEX-API-AppToken") String appToken,
            @PathVariable("sellerId") String sellerId,
            @PathVariable("skuId") String skuId
    );
}
