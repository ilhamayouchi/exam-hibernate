package ma.ens.dao;

import java.util.List;

public interface IDao<T> {
    public abstract boolean create(T o);

    boolean delete(T o);

    boolean update(T o);

    T findById(long id);

    List<T> findAll();
}
