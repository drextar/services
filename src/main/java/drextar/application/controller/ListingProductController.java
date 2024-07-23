package drextar.application.controller;

import drextar.application.service.ListingProductAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ListingProductController {

    private final ListingProductAppService listingProductApplicationService;

    public ListingProductController(ListingProductAppService listingProductApplicationService) {
        this.listingProductApplicationService = listingProductApplicationService;
    }

    @GetMapping("/{sellerId}/{skuId}")
    public ResponseEntity<Object> getProduct(
            @PathVariable String sellerId,
            @PathVariable String skuId
    ) {
        Object product = listingProductApplicationService.getProduct(sellerId, skuId);
        return ResponseEntity.ok(product);
    }
}
