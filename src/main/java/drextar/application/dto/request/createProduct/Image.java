package drextar.application.dto.request.createProduct;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @NotBlank(message = "imageName não pode ser vazio ou nulo")
    private String imageName;

    @NotBlank(message = "imageUrl não pode ser vazio ou nulo")
    private String imageUrl;
}
