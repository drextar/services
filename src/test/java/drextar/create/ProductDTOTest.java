//package drextar.create;
//
//import drextar.application.dto.ProductDTO;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class ProductDTOTest {
//
//    private ProductDTO productDTO;
//    private ProductDTO.Image image;
//    private ProductDTO.ProductSpecification productSpecification;
//    private ProductDTO.Pricing pricing;
//
//    @BeforeEach
//    void setUp() {
//        productDTO = new ProductDTO();
//        image = new ProductDTO.Image();
//        productSpecification = new ProductDTO.ProductSpecification();
//        pricing = new ProductDTO.Pricing();
//    }
//
//    @Test
//    void testCreateProductRequest() {
//        productDTO.setProductId("A1");
//        productDTO.setProductName("Product Name");
//        productDTO.setNameComplete("Complete Product Name");
//        productDTO.setProductDescription("Product Description");
//        productDTO.setBrandName("Brand Name");
//        productDTO.setSellerStockKeepingUnitId(1);
//        productDTO.setSkuName("SKU Name");
//        productDTO.setSellerId("Seller ID");
//        productDTO.setHeight(10);
//        productDTO.setWidth(20);
//        productDTO.setLength(30);
//        productDTO.setWeight(40);
//        productDTO.setRefId("Ref ID");
//        productDTO.setCategoryFullPath("Category/Full/Path");
//        productDTO.setImages(Arrays.asList(image));
//        productDTO.setProductSpecifications(Arrays.asList(productSpecification));
//        productDTO.setEan("1234567890123");
//        productDTO.setMeasurementUnit("unit");
//        productDTO.setUnitMultiplier(2);
//        productDTO.setAvailableQuantity(100);
//        productDTO.setPricing(pricing);
//
//        assertEquals("A1", productDTO.getProductId());
//        assertEquals("Product Name", productDTO.getProductName());
//        assertEquals("Complete Product Name", productDTO.getNameComplete());
//        assertEquals("Product Description", productDTO.getProductDescription());
//        assertEquals("Brand Name", productDTO.getBrandName());
//        assertEquals(1, productDTO.getSellerStockKeepingUnitId());
//        assertEquals("SKU Name", productDTO.getSkuName());
//        assertEquals("Seller ID", productDTO.getSellerId());
//        assertEquals(10, productDTO.getHeight());
//        assertEquals(20, productDTO.getWidth());
//        assertEquals(30, productDTO.getLength());
//        assertEquals(40, productDTO.getWeight());
//        assertEquals("Ref ID", productDTO.getRefId());
//        assertEquals("Category/Full/Path", productDTO.getCategoryFullPath());
//        assertEquals(1, productDTO.getImages().size());
//        assertEquals(1, productDTO.getProductSpecifications().size());
//        assertEquals("1234567890123", productDTO.getEan());
//        assertEquals("unit", productDTO.getMeasurementUnit());
//        assertEquals(2, productDTO.getUnitMultiplier());
//        assertEquals(100, productDTO.getAvailableQuantity());
//        assertEquals(pricing, productDTO.getPricing());
//    }
//
//    @Test
//    void testImage() {
//        image.setImageName("Image Name");
//        image.setImageUrl("http://image.url");
//
//        assertEquals("Image Name", image.getImageName());
//        assertEquals("http://image.url", image.getImageUrl());
//    }
//
//    @Test
//    void testProductSpecification() {
//        productSpecification.setFieldName("Field Name");
//        productSpecification.setFieldValues(Arrays.asList("Value1", "Value2"));
//
//        assertEquals("Field Name", productSpecification.getFieldName());
//        assertEquals(2, productSpecification.getFieldValues().size());
//        assertEquals("Value1", productSpecification.getFieldValues().get(0));
//        assertEquals("Value2", productSpecification.getFieldValues().get(1));
//    }
//
//    @Test
//    void testPricing() {
//        pricing.setCurrency("USD");
//        pricing.setSalePrice(99.99);
//        pricing.setCurrencySymbol("$");
//
//        assertEquals("USD", pricing.getCurrency());
//        assertEquals(99.99, pricing.getSalePrice());
//        assertEquals("$", pricing.getCurrencySymbol());
//    }
//}
