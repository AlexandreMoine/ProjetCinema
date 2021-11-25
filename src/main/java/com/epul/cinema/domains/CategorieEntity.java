package com.epul.cinema.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categorie", schema = "cinema", catalog = "")
public class CategorieEntity {
    private String codeCat;
    private String libelleCat;
    private String image;

    @Id
    @Column(name = "codeCat")
    public String getCodeCat() {
        return codeCat;
    }

    public void setCodeCat(String codeCat) {
        this.codeCat = codeCat;
    }

    @Basic
    @Column(name = "libelleCat")
    public String getLibelleCat() {
        return libelleCat;
    }

    public void setLibelleCat(String libelleCat) {
        this.libelleCat = libelleCat;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieEntity that = (CategorieEntity) o;
        return Objects.equals(codeCat, that.codeCat) && Objects.equals(libelleCat, that.libelleCat) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeCat, libelleCat, image);
    }
}
