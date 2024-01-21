package com.prince.service;

import com.prince.entity.User;

public interface UserService {

	public User saveUser(User user);

	public void removeSessionMessage();

}
