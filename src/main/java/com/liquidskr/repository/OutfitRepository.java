package com.liquidskr.repository;

import com.liquidskr.dto.OutfitDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OutfitRepository {
    private final List<OutfitDTO> database = new ArrayList<>();

    public OutfitDTO save(OutfitDTO outfit) {
        database.add(outfit);
        return outfit;
    }

    public List<OutfitDTO> findByUserId(String userId) {
        List<OutfitDTO> userOutfits = new ArrayList<>();
        for (OutfitDTO outfit : database) {
            if (outfit.getUserId().equals(userId)) {
                userOutfits.add(outfit);
            }
        }
        return userOutfits;
    }

    public Optional<OutfitDTO> findById(String id) {
        return database.stream().filter(outfit -> outfit.getId().equals(id)).findFirst();
    }
}
