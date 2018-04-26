package com.gabrielebonadiman.parent.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Beer.
 */
@Entity
@Table(name = "beer")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Beer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "abv")
    private Double abv;

    @Column(name = "ibu")
    private Integer ibu;

    @Column(name = "identification")
    private Integer identification;

    @Column(name = "name")
    private String name;

    @Column(name = "style")
    private String style;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAbv() {
        return abv;
    }

    public Beer abv(Double abv) {
        this.abv = abv;
        return this;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public Integer getIbu() {
        return ibu;
    }

    public Beer ibu(Integer ibu) {
        this.ibu = ibu;
        return this;
    }

    public void setIbu(Integer ibu) {
        this.ibu = ibu;
    }

    public Integer getIdentification() {
        return identification;
    }

    public Beer identification(Integer identification) {
        this.identification = identification;
        return this;
    }

    public void setIdentification(Integer identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public Beer name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public Beer style(String style) {
        this.style = style;
        return this;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Beer beer = (Beer) o;
        if (beer.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), beer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Beer{" +
            "id=" + getId() +
            ", abv=" + getAbv() +
            ", ibu=" + getIbu() +
            ", identification=" + getIdentification() +
            ", name='" + getName() + "'" +
            ", style='" + getStyle() + "'" +
            "}";
    }
}
