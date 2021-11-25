package com.epul.cinema.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie_character", schema = "cinema", catalog = "")
@IdClass(MovieCharacterPK.class)
public class MovieCharacter {
    private Long movie_id;
    private Long actor_id;
    private String firstname;
    private String lastname;
    private Movie movie;
    private Actor actor;

    @Id
    @Column(name = "id_movie", nullable = false)
    public Long getMovieId() {
        return movie_id;
    }
    public void setMovieId(Long movie_id) {
        this.movie_id = movie_id;
    }

    @Id
    @Column(name = "id_actor", nullable = false)
    public Long getActorId() {
        return actor_id;
    }
    public void setActorId(Long actor_id) {
        this.actor_id = actor_id;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieCharacter that = (MovieCharacter) o;
        return Objects.equals(movie_id, that.movie_id) && Objects.equals(actor_id, that.actor_id) && Objects.equals(firstname, that.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie_id, actor_id, firstname);
    }


    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    public Actor getActor() {
        return actor;
    }
    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
