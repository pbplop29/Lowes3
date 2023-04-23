package com.lowes3.osp.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "response_table")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "response_Id")
    private Integer responseId;
    @Column(name = "response_Details")    
    private String responseDetails;

    //Many-To-One relationship with survey
    @ManyToOne
    @JoinColumn(name = "question_Id")
    private Question question;
    
  //Many-To-One relationship with survey
    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User user;

}
