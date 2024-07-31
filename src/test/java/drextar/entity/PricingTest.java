package drextar.entity;

import drextar.application.dto.request.Pricing;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testPricingValido() {
        Pricing pricing = new Pricing("USD", 100, "$");

        Set<ConstraintViolation<Pricing>> violations = validator.validate(pricing);
        assertEquals(0, violations.size());
    }

    @Test
    void testPricingCurrencyInvalido() {
        Pricing pricing = new Pricing("", 100, "$");  // currency inválido

        Set<ConstraintViolation<Pricing>> violations = validator.validate(pricing);
        assertEquals(1, violations.size());  // Deve falhar no currency
    }

    @Test
    void testPricingCurrencyNulo() {
        Pricing pricing = new Pricing(null, 100, "$");  // currency nulo

        Set<ConstraintViolation<Pricing>> violations = validator.validate(pricing);
        assertEquals(1, violations.size());  // Deve falhar no currency
    }

    @Test
    void testPricingSalePriceInvalido() {
        Pricing pricing = new Pricing("USD", 0, "$");  // salePrice inválido

        Set<ConstraintViolation<Pricing>> violations = validator.validate(pricing);
        assertEquals(1, violations.size());  // Deve falhar no salePrice
    }

    @Test
    void testPricingSalePriceNulo() {
        Pricing pricing = new Pricing("USD", null, "$");  // salePrice nulo

        Set<ConstraintViolation<Pricing>> violations = validator.validate(pricing);
        assertEquals(1, violations.size());  // Deve falhar no salePrice
    }

    @Test
    void testPricingCurrencySymbolInvalido() {
        Pricing pricing = new Pricing("USD", 100, "");  // currencySymbol inválido

        Set<ConstraintViolation<Pricing>> violations = validator.validate(pricing);
        assertEquals(1, violations.size());  // Deve falhar no currencySymbol
    }

    @Test
    void testPricingCurrencySymbolNulo() {
        Pricing pricing = new Pricing("USD", 100, null);  // currencySymbol nulo

        Set<ConstraintViolation<Pricing>> violations = validator.validate(pricing);
        assertEquals(1, violations.size());  // Deve falhar no currencySymbol
    }

    @Test
    void testGettersAndSetters() {
        Pricing pricing = new Pricing();

        // Testando setter e getter para currency
        pricing.setCurrency("BRL");
        assertEquals("BRL", pricing.getCurrency());

        // Testando setter e getter para salePrice
        pricing.setSalePrice(500);
        assertEquals(500, pricing.getSalePrice());

        // Testando setter e getter para currencySymbol
        pricing.setCurrencySymbol("R$");
        assertEquals("R$", pricing.getCurrencySymbol());
    }
}
