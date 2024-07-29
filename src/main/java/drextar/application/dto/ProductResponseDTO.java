package drextar.application.dto;

import java.time.LocalDateTime;

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

    // Getters and Setters

    public boolean isPersisted() {
        return isPersisted;
    }

    public void setPersisted(boolean isPersisted) {
        this.isPersisted = isPersisted;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    public int getSkuSellerId() {
        return skuSellerId;
    }

    public void setSkuSellerId(int skuSellerId) {
        this.skuSellerId = skuSellerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public int getStockKeepingUnitId() {
        return stockKeepingUnitId;
    }

    public void setStockKeepingUnitId(int stockKeepingUnitId) {
        this.stockKeepingUnitId = stockKeepingUnitId;
    }

    public String getSellerStockKeepingUnitId() {
        return sellerStockKeepingUnitId;
    }

    public void setSellerStockKeepingUnitId(String sellerStockKeepingUnitId) {
        this.sellerStockKeepingUnitId = sellerStockKeepingUnitId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime getRequestedUpdateDate() {
        return requestedUpdateDate;
    }

    public void setRequestedUpdateDate(LocalDateTime requestedUpdateDate) {
        this.requestedUpdateDate = requestedUpdateDate;
    }
}
