package com.liquidskr.service;

import com.liquidskr.dto.OutfitDTO;
import com.liquidskr.repository.OutfitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OutfitService {
    private final OutfitRepository outfitRepository;

    public OutfitService(OutfitRepository outfitRepository) {
        this.outfitRepository = outfitRepository;
    }

    public OutfitDTO saveOutfit(String userId, OutfitDTO outfitDTO) {
        outfitDTO.setId(UUID.randomUUID().toString());
        outfitDTO.setUserId(userId);
        return outfitRepository.save(outfitDTO);
    }

    public List<OutfitDTO> getOutfitsByUser(String userId) {
        return outfitRepository.findByUserId(userId);
    }

    public OutfitDTO getOutfitById(String id) {
        return outfitRepository.findById(id).orElse(null);
    }
}
