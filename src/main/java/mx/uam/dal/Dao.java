package mx.uam.dal;

public interface Dao<T> {
    public void getAll();
    public int save(T entity);
    public void update(T entity);
    public boolean delete(int id);
    public boolean delete(T entity);
}
