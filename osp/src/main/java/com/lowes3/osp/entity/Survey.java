package com.lowes3.osp.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private Integer surveyId;
    private String surveyTitle;
    private String surveyDescription;
}
