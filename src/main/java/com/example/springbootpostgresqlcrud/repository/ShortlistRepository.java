package com.example.springbootpostgresqlcrud.repository;

import com.example.springbootpostgresqlcrud.model.Shortlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortlistRepository extends JpaRepository<Shortlist, Long> {
}
