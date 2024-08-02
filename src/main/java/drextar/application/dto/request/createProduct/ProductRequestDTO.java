package drextar.application.dto.request.createProduct;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductRequestDTO {


    @NotBlank(message = "ProductName não pode ser vazio ou nulo")
    private String productName;

    @NotBlank(message = "ProductId não pode ser vazio ou nulo")
    private String productId;

    @NotBlank(message = "ProductDescription não pode ser vazio ou nulo")
    private String productDescription;

    @NotBlank(message = "BrandName não pode ser vazio ou nulo")
    private String brandName;

    @NotBlank(message = "SkuName não pode ser vazio ou nulo")
    private String skuName;

    @NotBlank(message = "SellerId não pode ser vazio ou nulo")
    private String sellerId;

    @NotNull(message = "Height não pode ser nulo")
    @Min(value = 1, message = "Height deve ser maior que 0")
    private Integer height;

    @NotNull(message = "Width não pode ser nulo")
    @Min(value = 1, message = "Width deve ser maior que 0")
    private Integer width;

    @NotNull(message = "Length não pode ser nulo")
    @Min(value = 1, message = "Length deve ser maior que 0")
    private Integer length;

    @NotNull(message = "Weight não pode ser nulo")
    @Min(value = 1, message = "Weight deve ser maior que 0")
    private Integer weight;

    @NotBlank(message = "RefId não pode ser vazio ou nulo")
    private String refId;

    @NotBlank(message = "EAN não pode ser vazio ou nulo")
    private String ean;

    private Integer sellerStockKeepingUnitId;

    @NotBlank(message = "CategoryFullPath não pode ser vazio ou nulo")
    private String categoryFullPath;

    @Valid
    private List<SkuSpecification> skuSpecifications;

    @Valid
    private List<ProductSpecification> productSpecifications;

    @Valid
    @NotNull(message = "Images não pode ser nulo")
    @Size(min = 1, message = "Images não pode ser vazia")
    private List<Image> images;

    private String measurementUnit;

    private Integer unitMultiplier;

    @NotNull(message = "AvailableQuantity não pode ser nulo")
    @Min(value = 1, message = "AvailableQuantity deve ser maior que 0")
    private Integer availableQuantity;

    @Valid
    @NotNull(message = "Pricing não pode ser nulo")
    private Pricing pricing;

}
