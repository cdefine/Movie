package dao;

import domain.User;

public interface userDao {
	boolean check(String username,String passwd,int power) throws Exception;
	boolean addUser(User user) throws Exception;
	

}
