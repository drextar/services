package drextar.domain;

import drextar.infrastructure.ListingProductClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ListingProductDomainService {

    private final ListingProductClient listingProductClient;
    private final String appKey;
    private final String appToken;
//    private final String appKey = "vtexappkey-itaudemo-DTISMM";
//    private final String appToken = "GZVRBNKDKTUWBBJSRIQBSRRBMGRXPWJIEABWUOHPHCRNPJPXUBMKBKPUMETMXBMTUTYDSXUNVZYQJDQVBNFOAWGLZGPSDVVBHXALUMYIAZUTCLBIYPAUHZTJOZHTPFVO";


    public ListingProductDomainService(ListingProductClient listingProductClient,
                                       @Value("${vtex.api.appKey}") String appKey,
                                       @Value("${vtex.api.appToken}") String appToken) {
        this.listingProductClient = listingProductClient;
        this.appKey = appKey;
        this.appToken = appToken;
    }

    public Object getProduct(String sellerId, String skuId) {
        return listingProductClient.getProduct(appKey, appToken, sellerId, skuId);
    }
}