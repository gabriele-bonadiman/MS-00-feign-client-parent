package com.gabrielebonadiman.parent.repository;

import com.gabrielebonadiman.parent.domain.Beer;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Beer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {

    Beer findBeerByName(String name);

}
