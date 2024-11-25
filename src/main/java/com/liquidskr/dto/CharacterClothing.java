package com.liquidskr.dto;

import java.util.Map;

public class CharacterClothing {

    private String characterId; // 캐릭터 고유 ID
    private String characterName; // 캐릭터 이름
    private Map<String, ItemDTO> clothingParts; // 부위별 착용 아이템 (key: 부위 이름, value: 아이템)

    // 기본 생성자
    public CharacterClothing() {}

    // 모든 필드를 받는 생성자
    public CharacterClothing(String characterId, String characterName, Map<String, ItemDTO> clothingParts) {
        this.characterId = characterId;
        this.characterName = characterName;
        this.clothingParts = clothingParts;
    }

    // Getter와 Setter
    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Map<String, ItemDTO> getClothingParts() {
        return clothingParts;
    }

    public void setClothingParts(Map<String, ItemDTO> clothingParts) {
        this.clothingParts = clothingParts;
    }
}
