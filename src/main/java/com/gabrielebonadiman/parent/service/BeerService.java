package com.gabrielebonadiman.parent.service;

import com.gabrielebonadiman.parent.service.dto.BeerDTO;
import java.util.List;

/**
 * Service Interface for managing Beer.
 */
public interface BeerService {

    /**
     * Save a beer.
     *
     * @param beerDTO the entity to save
     * @return the persisted entity
     */
    BeerDTO save(BeerDTO beerDTO);

    /**
     * Get all the beers.
     *
     * @return the list of entities
     */
    List<BeerDTO> findAll();

    /**
     * Get the "id" beer.
     *
     * @param id the id of the entity
     * @return the entity
     */
    BeerDTO findOne(Long id);

    /**
     * Delete the "id" beer.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Get the beer.
     *
     * @param name the id of the entity
     * @return the entity
     */
    BeerDTO findByName(String name);

}
