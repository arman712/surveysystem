package ru.fr.surveysystem.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @DateTimeFormat()
    @Column(name = "start_time", updatable = false)
    private Timestamp startTime;

    @DateTimeFormat
    @Column(name = "end_time")
    private Timestamp endTime;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Question> questions;

}
