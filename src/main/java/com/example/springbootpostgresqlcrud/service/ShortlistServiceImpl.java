package com.example.springbootpostgresqlcrud.service;

import com.example.springbootpostgresqlcrud.model.Shortlist;
import com.example.springbootpostgresqlcrud.model.ShortlistDTO;
import com.example.springbootpostgresqlcrud.repository.ShortlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShortlistServiceImpl implements ShortlistService {

    private final ShortlistRepository shortlistRepository;

    public ShortlistServiceImpl(ShortlistRepository shortlistRepository) {
        this.shortlistRepository = shortlistRepository;
    }

    @Override
    public List<ShortlistDTO> getAllShortlists() {
        return shortlistRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ShortlistDTO> getShortlistById(Long id) {
        return shortlistRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public ShortlistDTO saveShortlist(ShortlistDTO dto) {
        Shortlist shortlist = convertToEntity(dto);
        Shortlist saved = shortlistRepository.save(shortlist);
        return convertToDTO(saved);
    }

    @Override
    public ShortlistDTO updateShortlist(Long id, ShortlistDTO dto) {
        Shortlist shortlist = shortlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shortlist not found with id " + id));

        shortlist.setCandidateName(dto.candidateName());
        shortlist.setPosition(dto.position());
        shortlist.setStatus(dto.status());

        Shortlist updated = shortlistRepository.save(shortlist);
        return convertToDTO(updated);
    }

    @Override
    public void deleteShortlist(Long id) {
        shortlistRepository.deleteById(id);
    }

    // Helper to convert entity to DTO
    private ShortlistDTO convertToDTO(Shortlist shortlist) {
        return new ShortlistDTO(
                shortlist.getId(),
                shortlist.getCandidateName(),
                shortlist.getPosition(),
                shortlist.getStatus()
        );
    }

    // Helper to convert DTO to entity
    private Shortlist convertToEntity(ShortlistDTO dto) {
        Shortlist shortlist = new Shortlist();
        shortlist.setCandidateName(dto.candidateName());
        shortlist.setPosition(dto.position());
        shortlist.setStatus(dto.status());
        return shortlist;
    }
}
