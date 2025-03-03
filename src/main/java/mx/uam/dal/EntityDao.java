package mx.uam.dal;

public interface EntityDao {
    public void getAll();
    public int save(Cliente cliente);
    public void update(Cliente cliente);
    public boolean delete(int id);
    public boolean delete(Cliente cliente);
}
