package drextar.application.dto.request.createProduct;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pricing {

    @NotBlank(message = "Currency não pode ser vazio ou nulo")
    private String currency;

    @NotNull(message = "SalePrice não pode ser nulo")
    @Min(value = 1, message = "SalePrice deve ser maior que 0")
    private Integer salePrice;

    @NotBlank(message = "CurrencySymbol não pode ser vazio ou nulo")
    private String currencySymbol;

}
