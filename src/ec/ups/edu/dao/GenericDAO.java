package ec.ups.edu.dao;

import java.util.List;

public interface GenericDAO<T, ID> {
	
	//public void createTable();
	public void create(T entity);
	public T read(ID id);
	public void update(T entity);
	public void delete(T entity);
	public List<T> find();
	int buscar(String email, String pwd);
}