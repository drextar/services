package drextar.entity;

import drextar.application.dto.request.Image;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImageTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testImageValida() {
        Image image = new Image("Produto Principal", "http://exemplo.com/imagem.jpg");

        Set<ConstraintViolation<Image>> violations = validator.validate(image);
        assertEquals(0, violations.size());
    }

    @Test
    void testImageNameInvalido() {
        Image image = new Image("", "http://exemplo.com/imagem.jpg");  // imageName inválido

        Set<ConstraintViolation<Image>> violations = validator.validate(image);
        assertEquals(1, violations.size());  // Deve falhar no imageName
    }

    @Test
    void testImageNameNulo() {
        Image image = new Image(null, "http://exemplo.com/imagem.jpg");  // imageName nulo

        Set<ConstraintViolation<Image>> violations = validator.validate(image);
        assertEquals(1, violations.size());  // Deve falhar no imageName
    }

    @Test
    void testImageUrlInvalido() {
        Image image = new Image("Produto Principal", "");  // imageUrl inválido

        Set<ConstraintViolation<Image>> violations = validator.validate(image);
        assertEquals(1, violations.size());  // Deve falhar no imageUrl
    }

    @Test
    void testImageUrlNulo() {
        Image image = new Image("Produto Principal", null);  // imageUrl nulo

        Set<ConstraintViolation<Image>> violations = validator.validate(image);
        assertEquals(1, violations.size());  // Deve falhar no imageUrl
    }

    @Test
    void testGetters() {
        Image image = new Image("Produto Principal", "http://exemplo.com/imagem.jpg");

        // Testando getter para imageName
        assertEquals("Produto Principal", image.getImageName());

        // Testando getter para imageUrl
        assertEquals("http://exemplo.com/imagem.jpg", image.getImageUrl());
    }
}
