package com.github.trickster88.jpadao;

import com.github.trickster88.dao.DAO;
import com.github.trickster88.domain.Entity;

import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class AbstractJPADAO<ID, T extends Entity<ID>> implements DAO<ID, T> {
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    public AbstractJPADAO(Class<T> entityClass) { this.entityClass = entityClass; }

    public AbstractJPADAO(Class<T> entityClass, EntityManager entityManager) {
        this(entityClass);

        this.entityManager = entityManager;
    }

    @SuppressWarnings("unchecked")
    @Override public @Nullable T get(ID id) { return (T) entityManager.find(entityClass, id); }

    public void add(T entity) { entityManager.persist(entity); }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) { this.entityManager = entityManager; }

    protected @Nullable T toSingleResult(List<T> result) {
        if(result.size() > 1) {
            throw new IllegalStateException();
        }

        return result.isEmpty() ? null : result.get(0);
    }

    public List<T> getAll() {
        CriteriaQuery<T> criteria = entityManager.getCriteriaBuilder().createQuery(entityClass);
        criteria.select(criteria.from(entityClass));

        return entityManager.createQuery(criteria).getResultList();
    }
}