package com.lowes3.osp.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "question_table")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_Id")
    private Integer questionId;
    @Column(name = "question_Type")
    private String questionType;
    @Column(name = "question_Description")
    private String questionDescription;
    
    //Many To One relationship with survey
    @ManyToOne
    @JoinColumn(name = "survey_Id")
    private Survey survey;
    
    //One to Many relationship with Response
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List <Response> response;
}
