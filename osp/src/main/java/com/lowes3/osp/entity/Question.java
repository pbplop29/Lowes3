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
    private Integer questionId;
    private String questionType;
    private String questionDescription;
}
