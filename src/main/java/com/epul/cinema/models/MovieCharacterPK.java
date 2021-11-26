package com.epul.cinema.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MovieCharacterPK implements Serializable {
    private Long movie_id;
    private Long actor_id;

    @Id
    @Column(name = "movie_id")
    public Long getMovieId() {
        return movie_id;
    }
    public void setMovieId(Long movie_id) {
        this.movie_id = movie_id;
    }

    @Id
    @Column(name = "actor_id")
    public Long getActorId() {
        return actor_id;
    }
    public void setActorId(Long actor_id) {
        this.actor_id = actor_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieCharacterPK that = (MovieCharacterPK) o;
        return Objects.equals(movie_id, that.movie_id) && Objects.equals(actor_id, that.actor_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie_id, actor_id);
    }
}
