package com.lowes3.osp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "survey_table")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "survey_Id")
    private Integer surveyId;
    @Column(name = "survey_Title")
    private String surveyTitle;
    @Column(name = "survey_Description")
    private String surveyDescription;
    
    
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;
}
