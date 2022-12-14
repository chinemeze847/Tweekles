package com.africa.teambox.tweekles.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String username;

    @CreationTimestamp
    @Column(name = "timestamp", columnDefinition= "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime timestamp;

    @Column(name = "message", length = 500)
    private String message;

}
