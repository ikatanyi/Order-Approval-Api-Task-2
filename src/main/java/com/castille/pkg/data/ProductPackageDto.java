package com.castille.pkg.data;

import com.castille.pkg.model.ProductPackage;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductPackageDto {
    @Schema(hidden = true)
    private Long id;
    @NotNull(message = "Order Id is required")
    private Long productId;
    @Schema(hidden = true)
    private String productName;
    private String description;

    public ProductPackage toProductPackage(){
        ProductPackage productPackage = new ProductPackage();
        productPackage.setDescription(this.getDescription());
        return productPackage;
    }
}
