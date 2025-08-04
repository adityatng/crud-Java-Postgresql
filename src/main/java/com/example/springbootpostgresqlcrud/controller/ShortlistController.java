package com.example.springbootpostgresqlcrud.controller;

import com.example.springbootpostgresqlcrud.model.ShortlistDTO;
import com.example.springbootpostgresqlcrud.service.ShortlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shortlists")
public class ShortlistController {

    private final ShortlistService shortlistService;

    public ShortlistController(ShortlistService shortlistService) {
        this.shortlistService = shortlistService;
    }

    // GET all shortlists
    @GetMapping
    public List<ShortlistDTO> getAllShortlists() {
        return shortlistService.getAllShortlists();
    }

    // GET shortlist by ID
    @GetMapping("/{id}")
    public ResponseEntity<ShortlistDTO> getShortlistById(@PathVariable Long id) {
        return shortlistService.getShortlistById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST create new shortlist
    @PostMapping
    public ResponseEntity<ShortlistDTO> createShortlist(@RequestBody ShortlistDTO shortlistDTO) {
        ShortlistDTO created = shortlistService.saveShortlist(shortlistDTO);
        return ResponseEntity.ok(created);
    }

    // PUT update shortlist
    @PutMapping("/{id}")
    public ResponseEntity<ShortlistDTO> updateShortlist(
            @PathVariable Long id,
            @RequestBody ShortlistDTO shortlistDTO
    ) {
        ShortlistDTO updated = shortlistService.updateShortlist(id, shortlistDTO);
        return ResponseEntity.ok(updated);
    }

    // DELETE shortlist
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShortlist(@PathVariable Long id) {
        shortlistService.deleteShortlist(id);
        return ResponseEntity.noContent().build();
    }
}
