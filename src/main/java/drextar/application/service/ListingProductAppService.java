package drextar.application.service;

import drextar.domain.ListingProductDomainService;
import org.springframework.stereotype.Service;
@Service
public class ListingProductAppService {

    private final ListingProductDomainService listingProductDomainService;

    public ListingProductAppService(ListingProductDomainService listingProductDomainService) {
        this.listingProductDomainService = listingProductDomainService;
    }

    public Object getProduct(String sellerId, String skuId) {
        return listingProductDomainService.getProduct(sellerId, skuId);
    }
}
