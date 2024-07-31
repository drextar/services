package drextar.entity;

//import drextar.application.dto.request.*;
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.Validation;
//import jakarta.validation.Validator;
//import jakarta.validation.ValidatorFactory;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class ProductRequestDTOTest {
//
//    private Validator validator;
//
//    @BeforeEach
//    void setUp() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        validator = factory.getValidator();
//    }
//
//    @Test
//    void testProductRequestDTOValid() {
//        ProductRequestDTO dto = new ProductRequestDTO();
//        dto.setProductName("iPhone 13");
//        dto.setProductId("A1");
//        dto.setProductDescription("Apple iPhone 13");
//        dto.setBrandName("Apple");
//        dto.setSkuName("iPhone 13 - 128GB");
//        dto.setSellerId("AppleStore");
//        dto.setHeight(10);
//        dto.setWidth(5);
//        dto.setLength(1);
//        dto.setWeight(200);
//        dto.setRefId("REF123");
//        dto.setEan("EAN123456789");
//        dto.setCategoryFullPath("Electronics/Phones");
//
//        dto.setImages(List.of(new Image("Main Image", "http://example.com/image.jpg")));
//
//        dto.setAvailableQuantity(100);
//        dto.setPricing(new Pricing("USD", 999, "$"));
//
//        Set<ConstraintViolation<ProductRequestDTO>> violations = validator.validate(dto);
//        assertEquals(0, violations.size());
//    }
//
//    @Test
//    void testProductRequestDTOInvalid() {
//        ProductRequestDTO dto = new ProductRequestDTO();  // Não definindo valores, tudo estará inválido
//
//        Set<ConstraintViolation<ProductRequestDTO>> violations = validator.validate(dto);
//
//        assertEquals(16, violations.size());
//    }
//
//    @Test
//    void testInvalidImage() {
//        ProductRequestDTO dto = new ProductRequestDTO();
//        dto.setProductName("iPhone 13");
//        dto.setProductId("A1");
//        dto.setProductDescription("Apple iPhone 13");
//        dto.setBrandName("Apple");
//        dto.setSkuName("iPhone 13 - 128GB");
//        dto.setSellerId("AppleStore");
//        dto.setHeight(10);
//        dto.setWidth(5);
//        dto.setLength(1);
//        dto.setWeight(200);
//        dto.setRefId("REF123");
//        dto.setEan("EAN123456789");
//        dto.setCategoryFullPath("Electronics/Phones");
//        dto.setAvailableQuantity(100);
//        dto.setPricing(new Pricing("USD", 999, "$"));
//
//        dto.setImages(List.of(new Image("", "")));  // Campos inválidos em Image
//
//        Set<ConstraintViolation<ProductRequestDTO>> violations = validator.validate(dto);
//
//        for (ConstraintViolation<ProductRequestDTO> violation : violations) {
//            System.out.println("Violation: " + violation.getPropertyPath() + " - " + violation.getMessage());
//        }
//
//        assertEquals(2, violations.size());  // Porque imageName e imageUrl são @NotBlank
//    }
//
//    @Test
//    void testInvalidSkuSpecification() {
//        ProductRequestDTO dto = new ProductRequestDTO();
//        dto.setProductName("iPhone 13");
//        dto.setProductId("A1");
//        dto.setProductDescription("Apple iPhone 13");
//        dto.setBrandName("Apple");
//        dto.setSkuName("iPhone 13 - 128GB");
//        dto.setSellerId("AppleStore");
//        dto.setHeight(10);
//        dto.setWidth(5);
//        dto.setLength(1);
//        dto.setWeight(200);
//        dto.setRefId("REF123");
//        dto.setEan("EAN123456789");
//        dto.setCategoryFullPath("Electronics/Phones");
//        dto.setAvailableQuantity(100);
//        dto.setPricing(new Pricing("USD", 999, "$"));
//
//        dto.setImages(List.of(new Image("Main Image", "http://example.com/image.jpg")));
//
//        dto.setSkuSpecifications(List.of(new SkuSpecification()));
//
//        Set<ConstraintViolation<ProductRequestDTO>> violations = validator.validate(dto);
//
//        for (ConstraintViolation<ProductRequestDTO> violation : violations) {
//            System.out.println("Violation: " + violation.getPropertyPath() + " - " + violation.getMessage());
//        }
//
//        assertEquals(2, violations.size());  // fieldName e fieldValues são obrigatórios
//    }
//
//    @Test
//    void testInvalidProductSpecification() {
//        ProductRequestDTO dto = new ProductRequestDTO();
//        dto.setProductName("iPhone 13");
//        dto.setProductId("A1");
//        dto.setProductDescription("Apple iPhone 13");
//        dto.setBrandName("Apple");
//        dto.setSkuName("iPhone 13 - 128GB");
//        dto.setSellerId("AppleStore");
//        dto.setHeight(10);
//        dto.setWidth(5);
//        dto.setLength(1);
//        dto.setWeight(200);
//        dto.setRefId("REF123");
//        dto.setEan("EAN123456789");
//        dto.setCategoryFullPath("Electronics/Phones");
//        dto.setAvailableQuantity(100);
//        dto.setPricing(new Pricing("USD", 999, "$"));
//
//        dto.setImages(List.of(new Image("Main Image", "http://example.com/image.jpg")));
//
//        dto.setProductSpecifications(List.of(new ProductSpecification()));
//
//        Set<ConstraintViolation<ProductRequestDTO>> violations = validator.validate(dto);
//
//        assertEquals(2, violations.size());
//    }
//
//    @Test
//    void testInvalidPricing() {
//        ProductRequestDTO dto = new ProductRequestDTO();
//        dto.setProductName("iPhone 13");
//        dto.setProductId("A1");
//        dto.setProductDescription("Apple iPhone 13");
//        dto.setBrandName("Apple");
//        dto.setSkuName("iPhone 13 - 128GB");
//        dto.setSellerId("AppleStore");
//        dto.setHeight(10);
//        dto.setWidth(5);
//        dto.setLength(1);
//        dto.setWeight(200);
//        dto.setRefId("REF123");
//        dto.setEan("EAN123456789");
//        dto.setCategoryFullPath("Electronics/Phones");
//        dto.setAvailableQuantity(100);
//        dto.setImages(List.of(new Image("Main Image", "http://example.com/image.jpg")));
//        dto.setPricing(new Pricing());
//
//        Set<ConstraintViolation<ProductRequestDTO>> violations = validator.validate(dto);
//        assertEquals(3, violations.size());  // Currency, SalePrice, e CurrencySymbol são obrigatórios
//    }
//
//    @Test
//    void testInvalidPricingFields() {
//        Pricing pricing = new Pricing();  // Nenhum valor definido, deve haver 3 violações
//
//        Set<ConstraintViolation<Pricing>> violations = validator.validate(pricing);
//        assertEquals(3, violations.size());
//    }
//}

import drextar.application.dto.request.*;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductRequestDTOTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testGettersAndSetters() {
        ProductRequestDTO dto = new ProductRequestDTO();

        // Testando setter e getter para productName
        dto.setProductName("iPhone 13");
        assertEquals("iPhone 13", dto.getProductName());

        // Testando setter e getter para productId
        dto.setProductId("A1");
        assertEquals("A1", dto.getProductId());

        // Testando setter e getter para productDescription
        dto.setProductDescription("Apple iPhone 13");
        assertEquals("Apple iPhone 13", dto.getProductDescription());

        // Testando setter e getter para brandName
        dto.setBrandName("Apple");
        assertEquals("Apple", dto.getBrandName());

        // Testando setter e getter para skuName
        dto.setSkuName("iPhone 13 - 128GB");
        assertEquals("iPhone 13 - 128GB", dto.getSkuName());

        // Testando setter e getter para sellerId
        dto.setSellerId("AppleStore");
        assertEquals("AppleStore", dto.getSellerId());

        // Testando setter e getter para height
        dto.setHeight(10);
        assertEquals(10, dto.getHeight());

        // Testando setter e getter para width
        dto.setWidth(5);
        assertEquals(5, dto.getWidth());

        // Testando setter e getter para length
        dto.setLength(15);
        assertEquals(15, dto.getLength());

        // Testando setter e getter para weight
        dto.setWeight(200);
        assertEquals(200, dto.getWeight());

        // Testando setter e getter para refId
        dto.setRefId("REF123");
        assertEquals("REF123", dto.getRefId());

        // Testando setter e getter para ean
        dto.setEan("EAN123456789");
        assertEquals("EAN123456789", dto.getEan());

        // Testando setter e getter para sellerStockKeepingUnitId
        dto.setSellerStockKeepingUnitId(1);
        assertEquals(1, dto.getSellerStockKeepingUnitId());

        // Testando setter e getter para categoryFullPath
        dto.setCategoryFullPath("Electronics/Phones");
        assertEquals("Electronics/Phones", dto.getCategoryFullPath());

        // Testando setter e getter para skuSpecifications
        SkuSpecification skuSpec = new SkuSpecification("Color", List.of("Black"));
        dto.setSkuSpecifications(List.of(skuSpec));
        assertEquals(List.of(skuSpec), dto.getSkuSpecifications());

        // Testando setter e getter para productSpecifications
        ProductSpecification productSpec = new ProductSpecification("Storage", List.of("128GB"));
        dto.setProductSpecifications(List.of(productSpec));
        assertEquals(List.of(productSpec), dto.getProductSpecifications());

        // Testando setter e getter para images
        Image image = new Image("Main Image", "http://example.com/image.jpg");
        dto.setImages(List.of(image));
        assertEquals(List.of(image), dto.getImages());

        // Testando setter e getter para measurementUnit
        dto.setMeasurementUnit("Unit");
        assertEquals("Unit", dto.getMeasurementUnit());

        // Testando setter e getter para unitMultiplier
        dto.setUnitMultiplier(1);
        assertEquals(1, dto.getUnitMultiplier());

        // Testando setter e getter para availableQuantity
        dto.setAvailableQuantity(100);
        assertEquals(100, dto.getAvailableQuantity());

        // Testando setter e getter para pricing
        Pricing pricing = new Pricing("USD", 999, "$");
        dto.setPricing(pricing);
        assertEquals(pricing, dto.getPricing());
    }

    @Test
    void testProductRequestDTOValido() {
        ProductRequestDTO dto = new ProductRequestDTO();
        dto.setProductName("iPhone 13");
        dto.setProductId("A1");
        dto.setProductDescription("Apple iPhone 13");
        dto.setBrandName("Apple");
        dto.setSkuName("iPhone 13 - 128GB");
        dto.setSellerId("AppleStore");
        dto.setHeight(10);
        dto.setWidth(5);
        dto.setLength(1);
        dto.setWeight(200);
        dto.setRefId("REF123");
        dto.setEan("EAN123456789");
        dto.setCategoryFullPath("Electronics/Phones");
        dto.setAvailableQuantity(100);
        dto.setPricing(new Pricing("USD", 999, "$"));
        dto.setImages(List.of(new Image("Main Image", "http://example.com/image.jpg")));
        dto.setSkuSpecifications(List.of(new SkuSpecification("Color", List.of("Black"))));
        dto.setProductSpecifications(List.of(new ProductSpecification("Storage", List.of("128GB"))));

        Set<ConstraintViolation<ProductRequestDTO>> violations = validator.validate(dto);
        assertEquals(0, violations.size());
    }

    @Test
    void testProductRequestDTOComCamposObrigatoriosInvalidos() {
        ProductRequestDTO dto = new ProductRequestDTO();
        dto.setProductName("");  // Campo inválido
        dto.setProductId("");  // Campo inválido
        dto.setProductDescription("");  // Campo inválido
        dto.setBrandName("");  // Campo inválido
        dto.setSkuName("");  // Campo inválido
        dto.setSellerId("");  // Campo inválido
        dto.setHeight(0);  // Valor inválido
        dto.setWidth(0);  // Valor inválido
        dto.setLength(0);  // Valor inválido
        dto.setWeight(0);  // Valor inválido
        dto.setRefId("");  // Campo inválido
        dto.setEan("");  // Campo inválido
        dto.setCategoryFullPath("");  // Campo inválido
        dto.setAvailableQuantity(0);  // Valor inválido
        dto.setPricing(null);  // Campo nulo
        dto.setImages(null);  // Campo nulo

        Set<ConstraintViolation<ProductRequestDTO>> violations = validator.validate(dto);
        assertEquals(16, violations.size());  // Todos os campos obrigatórios devem falhar
    }

    @Test
    void testProductRequestDTOPartialInvalidFields() {
        ProductRequestDTO dto = new ProductRequestDTO();
        dto.setProductName("iPhone 13");
        dto.setProductId("A1");
        dto.setProductDescription("Apple iPhone 13");
        dto.setBrandName("Apple");
        dto.setSkuName("");  // Campo inválido
        dto.setSellerId("AppleStore");
        dto.setHeight(10);
        dto.setWidth(5);
        dto.setLength(1);
        dto.setWeight(200);
        dto.setRefId("REF123");
        dto.setEan("");  // Campo inválido
        dto.setCategoryFullPath("");  // Campo inválido
        dto.setAvailableQuantity(100);
        dto.setPricing(new Pricing("USD", 999, "$"));
        dto.setImages(List.of(new Image("", "")));  // Valores inválidos

        Set<ConstraintViolation<ProductRequestDTO>> violations = validator.validate(dto);
        assertEquals(5, violations.size());  // SkuName, EAN, CategoryFullPath, imageName, imageUrl
    }

    @Test
    void testProductRequestDTOComPrecoInvalido() {
        ProductRequestDTO dto = new ProductRequestDTO();
        dto.setProductName("iPhone 13");
        dto.setProductId("A1");
        dto.setProductDescription("Apple iPhone 13");
        dto.setBrandName("Apple");
        dto.setSkuName("iPhone 13 - 128GB");
        dto.setSellerId("AppleStore");
        dto.setHeight(10);
        dto.setWidth(5);
        dto.setLength(1);
        dto.setWeight(200);
        dto.setRefId("REF123");
        dto.setEan("EAN123456789");
        dto.setCategoryFullPath("Electronics/Phones");
        dto.setAvailableQuantity(100);
        dto.setPricing(new Pricing("USD", 0, "$"));  // Valor inválido
        dto.setImages(List.of(new Image("Main Image", "http://example.com/image.jpg")));

        Set<ConstraintViolation<ProductRequestDTO>> violations = validator.validate(dto);
        assertEquals(1, violations.size());  // Deve falhar no SalePrice
    }

    @Test
    void testProductRequestDTOSemImages() {
        ProductRequestDTO dto = new ProductRequestDTO();
        dto.setProductName("iPhone 13");
        dto.setProductId("A1");
        dto.setProductDescription("Apple iPhone 13");
        dto.setBrandName("Apple");
        dto.setSkuName("iPhone 13 - 128GB");
        dto.setSellerId("AppleStore");
        dto.setHeight(10);
        dto.setWidth(5);
        dto.setLength(1);
        dto.setWeight(200);
        dto.setRefId("REF123");
        dto.setEan("EAN123456789");
        dto.setCategoryFullPath("Electronics/Phones");
        dto.setAvailableQuantity(100);
        dto.setPricing(new Pricing("USD", 999, "$"));
        dto.setImages(null);  // Campo nulo

        Set<ConstraintViolation<ProductRequestDTO>> violations = validator.validate(dto);
        assertEquals(1, violations.size());  // Deve falhar por Images ser nulo
    }
}