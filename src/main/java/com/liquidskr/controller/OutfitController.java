package com.liquidskr.controller;

import com.liquidskr.dto.OutfitDTO;
import com.liquidskr.service.OutfitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/outfits")
public class OutfitController {
    private final OutfitService outfitService;

    public OutfitController(OutfitService outfitService) {
        this.outfitService = outfitService;
    }

    @PostMapping("/save")
    public OutfitDTO saveOutfit(@RequestParam String userId, @RequestBody OutfitDTO outfitDTO) {
        return outfitService.saveOutfit(userId, outfitDTO);
    }

    @GetMapping("/user/{userId}")
    public List<OutfitDTO> getUserOutfits(@PathVariable String userId) {
        return outfitService.getOutfitsByUser(userId);
    }

    @GetMapping("/{id}")
    public OutfitDTO getOutfitById(@PathVariable String id) {
        return outfitService.getOutfitById(id);
    }
}
