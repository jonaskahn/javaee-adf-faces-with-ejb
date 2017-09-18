package com.tuyendev.base;

import java.util.List;

public interface BaseService<Entity, DTO> {

    public void create(Entity entity) throws Exception;

    public void save(DTO dto) throws Exception;

    public void edit(Entity entity) throws Exception;

    public void update(DTO dto) throws Exception;

    public void remove(Entity entity) throws Exception;

    public void delete(DTO dto) throws Exception;

    public Entity find(Object id) throws Exception;

    public DTO findOne(Object id) throws Exception;

    public List<Entity> findAll() throws Exception;

    public List<DTO> getAll() throws Exception;

    public List<Entity> findRange(int[] range) throws Exception;

    public List<DTO> getRange(int[] range) throws Exception;

    public int count() throws Exception;
}
