package com.dojoitem.dojoitem.item;

import lombok.Data;
import javax.persistence.*;
import java.util.Objects;


@Data
@Entity
@Table(name = "item")

public class ItemEntity {

@Id
@Column(name = "item_Id")
    private int itemId;
@Column(name = "name")
    private String name;
@Column(name = "description")
    private String description;
@Column(name = "category")
    private String category;
@Column(name = "image_url")
    private String image_url;
@Column(name = "sellable")

    private boolean sellable;

    public ItemEntity() {
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

    public ItemEntity(int itemId, String name, String description, String category, String image_url, boolean sellable) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.image_url = image_url;
        this.sellable = sellable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity that = (ItemEntity) o;
        return itemId == that.itemId &&
                sellable == that.sellable &&
                name.equals(that.name) &&
                description.equals(that.description) &&
                category.equals(that.category) &&
                image_url.equals(that.image_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, description, category, image_url, sellable);
    }
}
