package drextar.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateProductRequest {

    private String productId;
    private String productName;
    private String nameComplete;
    private String productDescription;
    private String brandName;
    private int sellerStockKeepingUnitId;
    private String skuName;
    private String sellerId;
    private int height;
    private int width;
    private int length;
    private int weight;
    private String refId;
    private String categoryFullPath;
    private List<Image> images;
    private List<ProductSpecification> productSpecifications;
    private String ean;
    private String measurementUnit;
    private int unitMultiplier;
    private int availableQuantity;
    private Pricing pricing;

    // Getters and setters

    @Getter
    @Setter
    public static class Image {
        private String imageName;
        private String imageUrl;
        // Getters and setters
    }

    @Getter
    @Setter
    public static class ProductSpecification {
        private String fieldName;
        private List<String> fieldValues;
        // Getters and setters
    }

    @Getter
    @Setter
    public static class Pricing {
        private String currency;
        private double salePrice;
        private String currencySymbol;
        // Getters and setters
    }
}
