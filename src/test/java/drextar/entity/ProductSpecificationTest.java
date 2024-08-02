package drextar.entity;

import drextar.application.dto.request.createProduct.ProductSpecification;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductSpecificationTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testProductSpecificationValido() {
        ProductSpecification productSpec = new ProductSpecification();
        productSpec.setFieldName("Cor");
        productSpec.setFieldValues(List.of("Azul"));

        Set<ConstraintViolation<ProductSpecification>> violations = validator.validate(productSpec);
        assertEquals(0, violations.size());
    }

    @Test
    void testProductSpecificationFieldNameInvalido() {
        ProductSpecification productSpec = new ProductSpecification();
        productSpec.setFieldName("");  // fieldName inválido
        productSpec.setFieldValues(List.of("Azul"));

        Set<ConstraintViolation<ProductSpecification>> violations = validator.validate(productSpec);
        assertEquals(1, violations.size());  // Deve falhar no fieldName
    }

    @Test
    void testProductSpecificationFieldNameNulo() {
        ProductSpecification productSpec = new ProductSpecification();
        productSpec.setFieldName(null);  // fieldName inválido
        productSpec.setFieldValues(List.of("Azul"));

        Set<ConstraintViolation<ProductSpecification>> violations = validator.validate(productSpec);
        assertEquals(1, violations.size());  // Deve falhar no fieldName
    }

    @Test
    void testProductSpecificationFieldValuesVazio() {
        ProductSpecification productSpec = new ProductSpecification();
        productSpec.setFieldName("Cor");
        productSpec.setFieldValues(List.of());  // fieldValues inválido

        Set<ConstraintViolation<ProductSpecification>> violations = validator.validate(productSpec);
        assertEquals(1, violations.size());  // Deve falhar no fieldValues por estar vazio
    }

    @Test
    void testProductSpecificationFieldValuesNulo() {
        ProductSpecification productSpec = new ProductSpecification();
        productSpec.setFieldName("Cor");
        productSpec.setFieldValues(null);  // fieldValues inválido

        Set<ConstraintViolation<ProductSpecification>> violations = validator.validate(productSpec);
        assertEquals(1, violations.size());  // Deve falhar no fieldValues por ser nulo
    }

    @Test
    void testGettersAndSetters() {
        ProductSpecification productSpec = new ProductSpecification();

        // Testando setter e getter para fieldName
        productSpec.setFieldName("Tamanho");
        assertEquals("Tamanho", productSpec.getFieldName());

        // Testando setter e getter para fieldValues
        List<String> values = List.of("Grande");
        productSpec.setFieldValues(values);
        assertEquals(values, productSpec.getFieldValues());
    }
}
