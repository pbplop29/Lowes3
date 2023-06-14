package com.lowes3.osp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "question_table")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_Id")
    private Integer questionId;
    @Column(name = "question_Type")
    private String questionType;
    @Column(name = "question_Description")
    private String questionDescription;
    
    //Many-To-One relationship with survey
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_Id")
    private Survey survey;
    
    //One-to-Many relationship with Response
    @JsonManagedReference(value="question-response")
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Response> responses;

    public void setResponses(List<Response> responses) {
        this.responses = responses;
        for (Response response : responses) {
            response.setQuestion(this);
        }
    }
}