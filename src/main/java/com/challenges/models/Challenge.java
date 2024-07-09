package com.challenges.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Challenge {
    @Id
    private Long id;
    @Column(name = "challengeMonth")
    private String month;
    private String description;
}