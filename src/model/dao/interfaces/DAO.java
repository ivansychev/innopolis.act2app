package model.dao.interfaces;

import java.util.Collection;

public interface DAO<E, PK> {

    E getById(PK id);

    Collection<E> getAll();

    E save(E entity);

    PK insert(E entity);

    int update(E entity);

    int delete(E entity);
}