package com.example.springbootpostgresqlcrud.service;

import com.example.springbootpostgresqlcrud.model.ShortlistDTO;

import java.util.List;
import java.util.Optional;

public interface ShortlistService {

    List<ShortlistDTO> getAllShortlists();

    Optional<ShortlistDTO> getShortlistById(Long id);

    ShortlistDTO saveShortlist(ShortlistDTO shortlistDTO);

    ShortlistDTO updateShortlist(Long id, ShortlistDTO shortlistDTO);

    void deleteShortlist(Long id);
}
