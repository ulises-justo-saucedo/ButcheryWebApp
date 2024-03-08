package com.Butchery.dto;

import com.Butchery.entity.MeatEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @Getter @Setter @ToString
public class MeatDTO {
    @NotNull
    @NotEmpty
    private String type;
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    private int stock;
    @NotNull
    private float price;
    public MeatEntity toMeatEntity(long id){
        MeatEntity meatEntity = new MeatEntity();
        meatEntity.setId(id);
        meatEntity.setType(type);
        meatEntity.setDescription(description);
        meatEntity.setStock(stock);
        meatEntity.setPrice(price);
        return meatEntity;
    }
}
