package com.lowes3.osp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_Id")
    private Integer userId;

    @Column(name="user_Email_Address")
    private String userEmailAddress;

    @Column(name = "user_Name")
    private String userName;

    @Column(name = "user_Password")
    private String userPassword;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Response> responses;

    public void setResponses(List<Response> responses) {
        this.responses = responses;
        for (Response response : responses) {
            response.setUser(this);
        }
    }
}
