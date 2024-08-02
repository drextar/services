package drextar.application.dto.request.sendTracking;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendTrackingRequestDTO {

    @NotBlank(message = "courier não pode ser vazio ou nulo")
    private String courier;

    @NotBlank(message = "trackingNumber não pode ser vazio ou nulo")
    private String trackingNumber;

    @NotBlank(message = "trackingUrl não pode ser vazio ou nulo")
    private String trackingUrl;

    @NotBlank(message = "dispatchedDate não pode ser vazio ou nulo")
    private String dispatchedDate;

}
