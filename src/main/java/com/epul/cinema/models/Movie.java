package com.epul.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "movie", schema = "cinema", catalog = "")
public class Movie {
    private Long id;
    private String title;
    private Integer duration;
    private Date release_date;
    private Integer budget;
    private Integer revenue_amount;
    private Category category;
    private Director director;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "release_date")
    public Date getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(Date release_date) {
        this.release_date = release_date;
    }

    @Basic
    @Column(name = "budget")
    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "revenue_amount")
    public Integer getRevenueAmount() {
        return revenue_amount;
    }

    public void setRevenueAmount(Integer revenue_amount) {
        this.revenue_amount = revenue_amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie that = (Movie) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(duration, that.duration) && Objects.equals(release_date, that.release_date) && Objects.equals(budget, that.budget) && Objects.equals(revenue_amount, that.revenue_amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, duration, release_date, budget, revenue_amount);
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_code", referencedColumnName = "code", nullable = false)
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "director_id", referencedColumnName = "id", nullable = false)
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

}
