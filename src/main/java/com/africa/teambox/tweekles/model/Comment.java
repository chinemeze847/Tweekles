package com.africa.teambox.tweekles.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    private String username;

    @Column(name = "comment", length = 500)
    private String comment;

    @CreationTimestamp
    @Column(name = "timestamp", columnDefinition= "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime timestamp;
}


