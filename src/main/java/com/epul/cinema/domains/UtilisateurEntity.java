package com.epul.cinema.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "utilisateur", schema = "cinema", catalog = "")
@NamedQuery(name = "UtilisateurEntity.rechercheNom", query = "select ut  from UtilisateurEntity  ut where ut.nom = ?1")
public class UtilisateurEntity {
    private Long id;
    private String nom;
    private String mdp;
    private String role;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "mdp")
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilisateurEntity that = (UtilisateurEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nom, that.nom) && Objects.equals(mdp, that.mdp) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, mdp, role);
    }
}
