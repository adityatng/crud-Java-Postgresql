package com.example.springbootpostgresqlcrud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "shortlists")
public class Shortlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String candidateName;
    private String position;
    private String status;

    // Constructors
    public Shortlist() {
    }

    public Shortlist(String candidateName, String position, String status) {
        this.candidateName = candidateName;
        this.position = position;
        this.status = status;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}