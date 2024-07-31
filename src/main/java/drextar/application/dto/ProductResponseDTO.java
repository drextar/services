package drextar.application.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductResponseDTO {

    private boolean isPersisted;
    private boolean isRemoved;
    private int skuSellerId;
    private String sellerId;
    private int stockKeepingUnitId;
    private String sellerStockKeepingUnitId;
    private boolean isActive;
    private LocalDateTime updateDate;
    private LocalDateTime requestedUpdateDate;

}
