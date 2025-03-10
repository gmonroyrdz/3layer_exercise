package mx.uam.dal;

import java.util.List;

public interface EntityDao<T> {
    public List<T> getAll();
    public T save(T entity);
    public T update(T entity);
    public boolean delete(int id);
    public boolean delete(T entity);
}
