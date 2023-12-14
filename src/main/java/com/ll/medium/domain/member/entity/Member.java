package com.ll.medium.domain.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;

    public String getPassword() {

        return null;
    }
}
