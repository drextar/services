package drextar.application.controller;

import drextar.application.dto.request.sendTracking.SendTrackingRequestDTO;
import drextar.application.service.SendTrackingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class SendTrackingController {

    @Autowired
    private SendTrackingService sendTrackingService;

    @PostMapping("/{marketplaceOrderId}/invoice/{invoiceNumber}/tracking")
    public void sendTracking(
            @PathVariable String marketplaceOrderId,
            @PathVariable String invoiceNumber,
            @RequestHeader("X-VTEX-API-AppKey") String appKey,
            @RequestHeader("X-VTEX-API-AppToken") String appToken,
            @Valid @RequestBody SendTrackingRequestDTO sendTrackingRequestDTO
    ) {
        sendTrackingService.sendTracking(marketplaceOrderId, invoiceNumber, appKey, appToken, sendTrackingRequestDTO);
    }
}
