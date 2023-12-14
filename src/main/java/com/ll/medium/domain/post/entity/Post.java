package com.ll.medium.domain.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer Id;
    private String title;
    private String body;
    private boolean isPublished;
    private Integer memberId;
}
