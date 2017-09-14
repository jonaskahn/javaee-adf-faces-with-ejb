package com.tuyendev.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.ArrayList;
import java.util.List;

public class AutoMapper<Entity, DTO> {

    private final Class<Entity> entity;
    private final Class<DTO> dto;
    private MapperFacade mapper;


    public AutoMapper(Class<Entity> entity, Class<DTO> dto) {
        this.entity = entity;
        this.dto = dto;
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(entity, dto);
        mapper = mapperFactory.getMapperFacade();
    }

    public DTO entityToDTO(Entity e) {
        return mapper.map(e, dto);
    }

    public Entity dtoToEntity(DTO d) {
        return mapper.map(d, entity);
    }

    public List<DTO> entityToDTO(List<Entity> le) {
        List<DTO> dtos = new ArrayList<DTO>();
        le.forEach(e -> dtos.add(entityToDTO(e)));
        return dtos;
    }

    public List<Entity> dtoToEntity(List<DTO> ld) {
        List<Entity> entities = new ArrayList<Entity>();
        ld.forEach(d -> entities.add(dtoToEntity(d)));
        return entities;
    }

}
