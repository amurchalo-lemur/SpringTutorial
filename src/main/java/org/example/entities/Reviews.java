package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "review", schema = "public")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int idReview;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "revie")
    private String review;
}
