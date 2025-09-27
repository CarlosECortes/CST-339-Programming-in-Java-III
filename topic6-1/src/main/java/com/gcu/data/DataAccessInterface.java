package com.gcu.data;
/**
 * Generic DAO interface for CRUD ops.
 * T is the domain model type
 */
import java.util.List;

public interface DataAccessInterface <T>{
	
	public List<T> findAll();
	public T findById(String id);  // NEW for MongoDB
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
}
