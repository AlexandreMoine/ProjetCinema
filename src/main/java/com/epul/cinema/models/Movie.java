package com.epul.cinema.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie", schema = "cinema")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String title;

    @Basic
    @Column(columnDefinition = "text")
    private String description;

    @Basic
    @Column(name = "cover_path")
    private String coverPath;

    @Basic
    private Integer duration;

    @Basic
    @Column(name = "release_date")
    private Date releaseDate;


    // TODO
    /**
     * information pas intéressante ?
     **/
//    @Basic
//    private Integer budget;
//
//    @Basic
//    private Integer revenue_amount;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "director_id", referencedColumnName = "id", nullable = true)
    private Director director;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_categories",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
