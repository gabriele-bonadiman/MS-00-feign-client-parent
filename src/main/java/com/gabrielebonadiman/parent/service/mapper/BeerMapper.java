package com.gabrielebonadiman.parent.service.mapper;

import com.gabrielebonadiman.parent.domain.*;
import com.gabrielebonadiman.parent.service.dto.BeerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Beer and its DTO BeerDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BeerMapper extends EntityMapper<BeerDTO, Beer> {



    default Beer fromId(Long id) {
        if (id == null) {
            return null;
        }
        Beer beer = new Beer();
        beer.setId(id);
        return beer;
    }
}
