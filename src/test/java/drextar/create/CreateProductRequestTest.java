package drextar.create;

import drextar.application.dto.CreateProductRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateProductRequestTest {

    private CreateProductRequest createProductRequest;
    private CreateProductRequest.Image image;
    private CreateProductRequest.ProductSpecification productSpecification;
    private CreateProductRequest.Pricing pricing;

    @BeforeEach
    void setUp() {
        createProductRequest = new CreateProductRequest();
        image = new CreateProductRequest.Image();
        productSpecification = new CreateProductRequest.ProductSpecification();
        pricing = new CreateProductRequest.Pricing();
    }

    @Test
    void testCreateProductRequest() {
        createProductRequest.setProductId("A1");
        createProductRequest.setProductName("Product Name");
        createProductRequest.setNameComplete("Complete Product Name");
        createProductRequest.setProductDescription("Product Description");
        createProductRequest.setBrandName("Brand Name");
        createProductRequest.setSellerStockKeepingUnitId(1);
        createProductRequest.setSkuName("SKU Name");
        createProductRequest.setSellerId("Seller ID");
        createProductRequest.setHeight(10);
        createProductRequest.setWidth(20);
        createProductRequest.setLength(30);
        createProductRequest.setWeight(40);
        createProductRequest.setRefId("Ref ID");
        createProductRequest.setCategoryFullPath("Category/Full/Path");
        createProductRequest.setImages(Arrays.asList(image));
        createProductRequest.setProductSpecifications(Arrays.asList(productSpecification));
        createProductRequest.setEan("1234567890123");
        createProductRequest.setMeasurementUnit("unit");
        createProductRequest.setUnitMultiplier(2);
        createProductRequest.setAvailableQuantity(100);
        createProductRequest.setPricing(pricing);

        assertEquals("A1", createProductRequest.getProductId());
        assertEquals("Product Name", createProductRequest.getProductName());
        assertEquals("Complete Product Name", createProductRequest.getNameComplete());
        assertEquals("Product Description", createProductRequest.getProductDescription());
        assertEquals("Brand Name", createProductRequest.getBrandName());
        assertEquals(1, createProductRequest.getSellerStockKeepingUnitId());
        assertEquals("SKU Name", createProductRequest.getSkuName());
        assertEquals("Seller ID", createProductRequest.getSellerId());
        assertEquals(10, createProductRequest.getHeight());
        assertEquals(20, createProductRequest.getWidth());
        assertEquals(30, createProductRequest.getLength());
        assertEquals(40, createProductRequest.getWeight());
        assertEquals("Ref ID", createProductRequest.getRefId());
        assertEquals("Category/Full/Path", createProductRequest.getCategoryFullPath());
        assertEquals(1, createProductRequest.getImages().size());
        assertEquals(1, createProductRequest.getProductSpecifications().size());
        assertEquals("1234567890123", createProductRequest.getEan());
        assertEquals("unit", createProductRequest.getMeasurementUnit());
        assertEquals(2, createProductRequest.getUnitMultiplier());
        assertEquals(100, createProductRequest.getAvailableQuantity());
        assertEquals(pricing, createProductRequest.getPricing());
    }

    @Test
    void testImage() {
        image.setImageName("Image Name");
        image.setImageUrl("http://image.url");

        assertEquals("Image Name", image.getImageName());
        assertEquals("http://image.url", image.getImageUrl());
    }

    @Test
    void testProductSpecification() {
        productSpecification.setFieldName("Field Name");
        productSpecification.setFieldValues(Arrays.asList("Value1", "Value2"));

        assertEquals("Field Name", productSpecification.getFieldName());
        assertEquals(2, productSpecification.getFieldValues().size());
        assertEquals("Value1", productSpecification.getFieldValues().get(0));
        assertEquals("Value2", productSpecification.getFieldValues().get(1));
    }

    @Test
    void testPricing() {
        pricing.setCurrency("USD");
        pricing.setSalePrice(99.99);
        pricing.setCurrencySymbol("$");

        assertEquals("USD", pricing.getCurrency());
        assertEquals(99.99, pricing.getSalePrice());
        assertEquals("$", pricing.getCurrencySymbol());
    }
}
