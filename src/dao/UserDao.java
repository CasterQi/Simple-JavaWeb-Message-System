package dao;

import model.User;



public interface UserDao{

  public User findByUsername(String username);
  public void add(User user);
}
