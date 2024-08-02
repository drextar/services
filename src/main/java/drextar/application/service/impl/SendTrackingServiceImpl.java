package drextar.application.service.impl;

import drextar.application.dto.request.sendTracking.SendTrackingRequestDTO;
import drextar.application.service.SendTrackingService;
import drextar.infrastructure.feign.SendTrackingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendTrackingServiceImpl implements SendTrackingService {

    @Autowired
    private SendTrackingClient sendTrackingClient;

    @Override
    public void sendTracking(String marketplaceOrderId, String invoiceNumber, String appKey, String appToken, SendTrackingRequestDTO sendTrackingRequestDTO) {
        sendTrackingClient.sendTracking(marketplaceOrderId, invoiceNumber, appKey, appToken, sendTrackingRequestDTO);
    }
}