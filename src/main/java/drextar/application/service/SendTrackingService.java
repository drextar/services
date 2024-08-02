package drextar.application.service;

import drextar.application.dto.request.sendTracking.SendTrackingRequestDTO;

public interface SendTrackingService {
    void sendTracking(String marketplaceOrderId, String invoiceNumber, String appKey, String appToken, SendTrackingRequestDTO sendTrackingRequestDTO);
}
