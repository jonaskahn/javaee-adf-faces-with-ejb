package com.tuyendev.base;

import com.tuyendev.mapper.AdvanceMapper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public abstract class BaseFacade<Entity, DTO> implements BaseService<Entity,DTO>{

    private Class<Entity> entityClass;
    private Class<DTO> dtoClass;

    public BaseFacade(Class<Entity> entityClass, Class<DTO> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    protected abstract AdvanceMapper getMapper();

    protected abstract EntityManager getEntityManager();

    public void create(Entity entity) throws Exception {
        getEntityManager().persist(entity);
    }

    public void save(DTO dto) throws Exception {
        Entity entity = (Entity) getMapper().dtoToEntity(dto);
        create(entity);
    }

    public void edit(Entity entity) throws Exception {
        getEntityManager().merge(entity);
    }

    public void update(DTO dto) throws Exception {
        Entity entity = (Entity) getMapper().dtoToEntity(dto);
        edit(entity);
    }

    public void remove(Entity entity) throws Exception {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public void delete(DTO dto) throws Exception {
        Entity entity = (Entity) getMapper().dtoToEntity(dto);
        remove(entity);
    }

    public Entity find(Object id) throws Exception {
        return getEntityManager().find(entityClass, id);
    }

    public DTO findOne(Object id) throws Exception {
        Entity entity = find(id);
        return entity == null ? dtoClass.newInstance() : (DTO) getMapper().entityToDTO(entity);
    }

    public List<Entity> findAll() throws Exception {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<DTO> getAll() throws Exception {
        System.out.print("START_INVOKED");
        List result = findAll();
        return result == null ? new ArrayList<DTO>() : getMapper().entityToDTO(result);
    }

    public List<Entity> findRange(int[] range) throws Exception {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public List<DTO> getRange(int[] range) throws Exception {
        List result = findRange(range);
        return result == null ? new ArrayList<DTO>() : getMapper().entityToDTO(result);
    }

    public int count() throws Exception {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Entity> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
