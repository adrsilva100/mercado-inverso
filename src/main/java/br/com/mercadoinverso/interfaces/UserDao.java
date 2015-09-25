package br.com.mercadoinverso.interfaces;

import com.mercadoinverso.entities.User;

public interface UserDao {

	public User findUserByEmail(String email);

}