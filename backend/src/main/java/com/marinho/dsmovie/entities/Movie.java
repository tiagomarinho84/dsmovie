package com.marinho.dsmovie.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double score;
    private Integer count;
    private String title;
    private String image;

    @OneToMany(mappedBy = "id.movie")
    @ToString.Exclude
    private Set<Score> scores;

    public Set<Score> getScores() {
        return scores;
    }

    public Movie() {
    }

    public Movie(Long id, Double score, Integer count, String title, String image, Set<Score> scores) {
        this.id = id;
        this.score = score;
        this.count = count;
        this.title = title;
        this.image = image;
        this.scores = scores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movie movie = (Movie) o;
        return id != null && Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
