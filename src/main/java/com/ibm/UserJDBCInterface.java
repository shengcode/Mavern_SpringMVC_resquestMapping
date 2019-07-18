package com.ibm;

import java.util.ArrayList;

public interface UserJDBCInterface {
	public User getUser(String userId);
	public boolean deleteUser(String userId);
	public boolean updateUser(User user);
	public ArrayList<User> getAllUsers();
	public boolean addUser(User user);
}