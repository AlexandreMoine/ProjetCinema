package com.epul.cinema.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "realisateur", schema = "cinema", catalog = "")
public class RealisateurEntity {
    private Integer noRea;
    private String nomRea;
    private String prenRea;

    @Id
    @Column(name = "noRea")
    public Integer getNoRea() {
        return noRea;
    }

    public void setNoRea(Integer noRea) {
        this.noRea = noRea;
    }

    @Basic
    @Column(name = "nomRea")
    public String getNomRea() {
        return nomRea;
    }

    public void setNomRea(String nomRea) {
        this.nomRea = nomRea;
    }

    @Basic
    @Column(name = "prenRea")
    public String getPrenRea() {
        return prenRea;
    }

    public void setPrenRea(String prenRea) {
        this.prenRea = prenRea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealisateurEntity that = (RealisateurEntity) o;
        return Objects.equals(noRea, that.noRea) && Objects.equals(nomRea, that.nomRea) && Objects.equals(prenRea, that.prenRea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noRea, nomRea, prenRea);
    }
}
