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
    void testGettersAndSetters() {
        // Criando uma instância da classe Image
        Image image = new Image();

        // Testando o setter e getter para imageName
        image.setImageName("Imagem Principal");
        assertEquals("Imagem Principal", image.getImageName());

        // Testando o setter e getter para imageUrl
        image.setImageUrl("http://exemplo.com/imagem.jpg");
        assertEquals("http://exemplo.com/imagem.jpg", image.getImageUrl());
    }

    @Test
    void testAllArgsConstructor() {
        // Criando uma instância usando o construtor com argumentos
        Image image = new Image("Imagem Principal", "http://exemplo.com/imagem.jpg");

        // Verificando se os valores estão corretamente atribuídos
        assertEquals("Imagem Principal", image.getImageName());
        assertEquals("http://exemplo.com/imagem.jpg", image.getImageUrl());
    }

    @Test
    void testNoArgsConstructor() {
        // Criando uma instância usando o construtor sem argumentos
        Image image = new Image();

        // Verificando se os valores estão nulos inicialmente
        assertEquals(null, image.getImageName());
        assertEquals(null, image.getImageUrl());
    }
}
