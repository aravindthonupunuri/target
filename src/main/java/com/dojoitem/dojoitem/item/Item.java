package com.dojoitem.dojoitem.item;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class Item {
    @JsonProperty("item_id")
    private int item_id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("category")
    private String category;
    @JsonProperty("image_url")
    private String image_url;
    @JsonProperty("sellable")
    private int sellable;

    public Item(int item_Id, String name, String description, String category, String image_url, int sellable) {
        this.item_id = item_Id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.image_url = image_url;
        this.sellable = sellable;
    }

    public Item() {
    }


    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
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

    public int isSellable() {
        return sellable;
    }

    public void setSellable(int sellable) {
        this.sellable = sellable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return item_id == item.item_id &&
                sellable == item.sellable &&
                name.equals(item.name) &&
                description.equals(item.description) &&
                category.equals(item.category) &&
                image_url.equals(item.image_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id, name, description, category, image_url, sellable);
    }
}
