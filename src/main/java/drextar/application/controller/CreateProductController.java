package drextar.application.controller;

import drextar.application.dto.CreateProductRequest;
import drextar.application.service.CreateProductAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class CreateProductController {

    private final CreateProductAppService createProductAppService;

    public CreateProductController(CreateProductAppService createProductAppService) {
        this.createProductAppService = createProductAppService;
    }

    @PutMapping("/{sellerId}/{productId}")
    public ResponseEntity<Void> createProduct(
            @PathVariable String sellerId,
            @PathVariable String productId,
            @RequestBody CreateProductRequest createProductRequest
    ) {
        createProductAppService.createProduct(sellerId, productId, createProductRequest);
        return ResponseEntity.ok().build();
    }
}
