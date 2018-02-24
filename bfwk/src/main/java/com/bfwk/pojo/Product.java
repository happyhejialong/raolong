package com.bfwk.pojo;

import javax.validation.constraints.NotNull;

import com.bfwk.common.validate.Delete;
import com.bfwk.common.validate.Select;
import com.bfwk.common.validate.Update;

public class Product extends BasePojo {
    @NotNull(message = "id不为空", groups = { Select.class, Update.class, Delete.class })
    private String id;
    private String category;
    private String name;
    private Double price;
    private Double tradePrice;
    private String images;
    private Double sellPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(Double tradePrice) {
        this.tradePrice = tradePrice;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

}
