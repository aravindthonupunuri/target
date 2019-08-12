package com.dojoitem.dojoitem.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    @JsonProperty("itemId")
    private int itemId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("category")
    private String category;
    @JsonProperty("image_url")
    private String image_url;
    @JsonProperty("sellable")
    private boolean sellable;

    public Item(int item_Id, String name, String description, String category, String image_url, boolean sellable) {
        this.itemId = item_Id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.image_url = image_url;
        this.sellable = sellable;
    }

    public Item() {
    }


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public boolean isSellable() {
        return sellable;
    }

    public void setSellable(boolean sellable) {
        this.sellable = sellable;
    }
}