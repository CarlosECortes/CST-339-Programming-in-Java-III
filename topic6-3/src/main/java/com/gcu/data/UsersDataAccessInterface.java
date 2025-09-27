package com.gcu.data;

public interface UsersDataAccessInterface<T> {
	T findByUsername(String username);

}
