package com.liquidskr.dto;

public class ItemDTO {
    private String id; // 아이템 고유 ID
    private String name; // 아이템 이름
    private String description; // 아이템 설명
    private String imageUrl; // 아이템 이미지 URL

    // 기본 생성자
    public ItemDTO() {}

    // 모든 필드를 받는 생성자
    public ItemDTO(String id, String name, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    // Getter와 Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
