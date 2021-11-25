package com.epul.cinema.domains;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "film", schema = "cinema", catalog = "")
public class FilmEntity {
    private Integer noFilm;
    private String titre;
    private Integer duree;
    private Date dateSortie;
    private Integer budget;
    private Integer montantRecette;
    private CategorieEntity categorieByCodeCat;
    private RealisateurEntity realisateur;

    @Id
    @Column(name = "noFilm")
    public Integer getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(Integer noFilm) {
        this.noFilm = noFilm;
    }

    @Basic
    @Column(name = "titre")
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Basic
    @Column(name = "duree")
    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    @Basic
    @Column(name = "dateSortie")
    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
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
    @Column(name = "montantRecette")
    public Integer getMontantRecette() {
        return montantRecette;
    }

    public void setMontantRecette(Integer montantRecette) {
        this.montantRecette = montantRecette;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmEntity that = (FilmEntity) o;
        return Objects.equals(noFilm, that.noFilm) && Objects.equals(titre, that.titre) && Objects.equals(duree, that.duree) && Objects.equals(dateSortie, that.dateSortie) && Objects.equals(budget, that.budget) && Objects.equals(montantRecette, that.montantRecette);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noFilm, titre, duree, dateSortie, budget, montantRecette);
    }

    @ManyToOne
    @JoinColumn(name = "codeCat", referencedColumnName = "codeCat", nullable = false)
    public CategorieEntity getCategorieByCodeCat() {
        return categorieByCodeCat;
    }

    public void setCategorieByCodeCat(CategorieEntity categorieByCodeCat) {
        this.categorieByCodeCat = categorieByCodeCat;
    }


    @ManyToOne
    @JoinColumn(name = "noRea", referencedColumnName = "noRea", nullable = false)
    public RealisateurEntity getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(RealisateurEntity realisateur) {
        this.realisateur = realisateur;
    }

}
