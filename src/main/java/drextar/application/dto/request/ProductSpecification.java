package drextar.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSpecification {
    @NotBlank(message = "fieldName não pode ser vazio ou nulo")
    private String fieldName;

    @NotNull(message = "fieldValues não pode ser nulo")
    @Size(min = 1, message = "fieldValues não pode ser vazio")
    private List<String> fieldValues;
}
