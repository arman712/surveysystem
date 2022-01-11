package ru.fr.surveysystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;
}
