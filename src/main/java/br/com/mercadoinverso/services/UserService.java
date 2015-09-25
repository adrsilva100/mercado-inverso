package br.com.mercadoinverso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercadoinverso.entities.User;

import br.com.mercadoinverso.interfaces.UserDao;

@Service
@Transactional
public class UserService {

	private UserDao userDao;

	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public User findUserByEmail(String userName){
		return userDao.findUserByEmail(userName);
	}
}