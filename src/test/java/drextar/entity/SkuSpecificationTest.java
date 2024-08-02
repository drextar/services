package drextar.entity;

import drextar.application.dto.request.createProduct.SkuSpecification;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkuSpecificationTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testSkuSpecificationValido() {
        SkuSpecification skuSpec = new SkuSpecification();
        skuSpec.setFieldName("Tamanho da Tela");
        skuSpec.setFieldValues(List.of("6.1 polegadas"));

        Set<ConstraintViolation<SkuSpecification>> violations = validator.validate(skuSpec);
        assertEquals(0, violations.size());
    }

    @Test
    void testSkuSpecificationFieldNameInvalido() {
        SkuSpecification skuSpec = new SkuSpecification();
        skuSpec.setFieldName("");  // fieldName inválido
        skuSpec.setFieldValues(List.of("6.1 polegadas"));

        Set<ConstraintViolation<SkuSpecification>> violations = validator.validate(skuSpec);
        assertEquals(1, violations.size());  // Deve falhar no fieldName
    }

    @Test
    void testSkuSpecificationFieldNameNulo() {
        SkuSpecification skuSpec = new SkuSpecification();
        skuSpec.setFieldName(null);  // fieldName inválido
        skuSpec.setFieldValues(List.of("6.1 polegadas"));

        Set<ConstraintViolation<SkuSpecification>> violations = validator.validate(skuSpec);
        assertEquals(1, violations.size());  // Deve falhar no fieldName
    }

    @Test
    void testSkuSpecificationFieldValuesVazio() {
        SkuSpecification skuSpec = new SkuSpecification();
        skuSpec.setFieldName("Tamanho da Tela");
        skuSpec.setFieldValues(List.of());  // fieldValues inválido

        Set<ConstraintViolation<SkuSpecification>> violations = validator.validate(skuSpec);
        assertEquals(1, violations.size());  // Deve falhar no fieldValues por estar vazio
    }

    @Test
    void testSkuSpecificationFieldValuesNulo() {
        SkuSpecification skuSpec = new SkuSpecification();
        skuSpec.setFieldName("Tamanho da Tela");
        skuSpec.setFieldValues(null);  // fieldValues inválido

        Set<ConstraintViolation<SkuSpecification>> violations = validator.validate(skuSpec);
        assertEquals(1, violations.size());  // Deve falhar no fieldValues por ser nulo
    }

    @Test
    void testGettersAndSetters() {
        // Criando uma instância de SkuSpecification
        SkuSpecification skuSpecification = new SkuSpecification();

        // Testando o setter e getter para fieldName
        skuSpecification.setFieldName("Cor");
        assertEquals("Cor", skuSpecification.getFieldName());

        // Testando o setter e getter para fieldValues
        List<String> values = List.of("Preto", "Branco");
        skuSpecification.setFieldValues(values);
        assertEquals(values, skuSpecification.getFieldValues());
    }

    @Test
    void testAllArgsConstructor() {
        // Criando uma instância usando o construtor com argumentos
        List<String> values = List.of("Preto", "Branco");
        SkuSpecification skuSpecification = new SkuSpecification("Cor", values);

        // Verificando se os valores estão corretamente atribuídos
        assertEquals("Cor", skuSpecification.getFieldName());
        assertEquals(values, skuSpecification.getFieldValues());
    }

    @Test
    void testNoArgsConstructor() {
        // Criando uma instância usando o construtor sem argumentos
        SkuSpecification skuSpecification = new SkuSpecification();

        // Verificando se os valores estão nulos inicialmente
        assertEquals(null, skuSpecification.getFieldName());
        assertEquals(null, skuSpecification.getFieldValues());
    }
}
