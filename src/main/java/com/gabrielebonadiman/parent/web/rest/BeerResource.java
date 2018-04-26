package com.gabrielebonadiman.parent.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.gabrielebonadiman.parent.service.BeerService;
import com.gabrielebonadiman.parent.web.rest.errors.BadRequestAlertException;
import com.gabrielebonadiman.parent.web.rest.util.HeaderUtil;
import com.gabrielebonadiman.parent.service.dto.BeerDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Beer.
 */
@RestController
@RequestMapping("/api")
public class BeerResource {

    private final Logger log = LoggerFactory.getLogger(BeerResource.class);

    private static final String ENTITY_NAME = "beer";

    private final BeerService beerService;

    public BeerResource(BeerService beerService) {
        this.beerService = beerService;
    }

    /**
     * POST  /beers : Create a new beer.
     *
     * @param beerDTO the beerDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new beerDTO, or with status 400 (Bad Request) if the beer has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/beers")
    @Timed
    public ResponseEntity<BeerDTO> createBeer(@RequestBody BeerDTO beerDTO) throws URISyntaxException {
        log.debug("REST request to save Beer : {}", beerDTO);
        if (beerDTO.getId() != null) {
            throw new BadRequestAlertException("A new beer cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BeerDTO result = beerService.save(beerDTO);
        return ResponseEntity.created(new URI("/api/beers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /beers : Updates an existing beer.
     *
     * @param beerDTO the beerDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated beerDTO,
     * or with status 400 (Bad Request) if the beerDTO is not valid,
     * or with status 500 (Internal Server Error) if the beerDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/beers")
    @Timed
    public ResponseEntity<BeerDTO> updateBeer(@RequestBody BeerDTO beerDTO) throws URISyntaxException {
        log.debug("REST request to update Beer : {}", beerDTO);
        if (beerDTO.getId() == null) {
            return createBeer(beerDTO);
        }
        BeerDTO result = beerService.save(beerDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, beerDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /beers : get all the beers.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of beers in body
     */
    @GetMapping("/beers")
    @Timed
    public List<BeerDTO> getAllBeers() {
        log.debug("REST request to get all Beers");
        return beerService.findAll();
        }

    /**
     * GET  /beers/:id : get the "id" beer.
     *
     * @param id the id of the beerDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the beerDTO, or with status 404 (Not Found)
     */
    @GetMapping("/beers/{id}")
    @Timed
    public ResponseEntity<BeerDTO> getBeer(@PathVariable Long id) {
        log.debug("REST request to get Beer : {}", id);
        BeerDTO beerDTO = beerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(beerDTO));
    }

    /**
     * DELETE  /beers/:id : delete the "id" beer.
     *
     * @param id the id of the beerDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/beers/{id}")
    @Timed
    public ResponseEntity<Void> deleteBeer(@PathVariable Long id) {
        log.debug("REST request to delete Beer : {}", id);
        beerService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * GET  /supplier-campaign-webs/update-landingpage
     * method used from @ CoreMicroserviceClient
     */
    @GetMapping("/beers/getBeerByName/{name}")
    @Timed
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BeerDTO> getBeerByName(@PathVariable String name) {
        BeerDTO beerDTO = beerService.findByName(name);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(beerDTO));
    }
}
