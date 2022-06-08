package service;

import java.sql.SQLException;
import java.util.List;

public interface GenenaSevice<T> {
    public void add(T t) throws SQLException;

    public T findById(int id);

    public List<T> findAll();

    public boolean update(T t) throws SQLException;

    public boolean delete(int id) throws SQLException;

    public List<T> findByName(String name);

    public List<T> findAllOrderByAge();

}
