package drextar.infrastructure.feign;

import drextar.application.config.FeignConfig;
import drextar.application.dto.request.sendTracking.SendTrackingRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "sendTrackingClient", url = "https://itaudemo.vtexcommercestable.com.br", configuration = FeignConfig.class)
public interface SendTrackingClient {

    @PostMapping("/pvt/orders/{marketplaceOrderId}/invoice/{invoiceNumber}")
    void sendTracking(
            @PathVariable("marketplaceOrderId") String marketplaceOrderId,
            @PathVariable("invoiceNumber") String invoiceNumber,
            @RequestHeader("X-VTEX-API-AppKey") String appKey,
            @RequestHeader("X-VTEX-API-AppToken") String appToken,
            @RequestBody SendTrackingRequestDTO sendTrackingRequestDTO
    );

}
