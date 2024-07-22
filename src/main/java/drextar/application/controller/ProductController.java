package drextar.application.controller;

import drextar.application.dto.ProductRequest;
import drextar.application.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping("/{sellerId}/{productId}")
    public ResponseEntity<Void> updateProduct(
            @PathVariable String sellerId,
            @PathVariable String productId,
            @RequestBody ProductRequest productRequest
    ) {
        productService.updateProduct(sellerId, productId, productRequest);
        return ResponseEntity.ok().build();
    }
}
