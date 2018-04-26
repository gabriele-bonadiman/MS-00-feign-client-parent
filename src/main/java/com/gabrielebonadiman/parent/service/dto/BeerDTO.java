package com.gabrielebonadiman.parent.service.dto;


import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Beer entity.
 */
public class BeerDTO implements Serializable {

    private Long id;

    private Double abv;

    private Integer ibu;

    private Integer identification;

    private String name;

    private String style;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public Integer getIbu() {
        return ibu;
    }

    public void setIbu(Integer ibu) {
        this.ibu = ibu;
    }

    public Integer getIdentification() {
        return identification;
    }

    public void setIdentification(Integer identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BeerDTO beerDTO = (BeerDTO) o;
        if(beerDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), beerDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BeerDTO{" +
            "id=" + getId() +
            ", abv=" + getAbv() +
            ", ibu=" + getIbu() +
            ", identification=" + getIdentification() +
            ", name='" + getName() + "'" +
            ", style='" + getStyle() + "'" +
            "}";
    }
}
