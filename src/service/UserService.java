package service;

import dao.DaoFactory;
import dao.UserDao;
import model.User;


public class UserService{

  private UserDao userDao = DaoFactory.getUserDao();

  public void register(User user) throws UserException{
     User _user = userDao.findByUsername(user.getUsername());
     if(_user != null) throw  new UserException("用户名"+user.getUsername()+"已被注册");
     userDao.add(user);
  }

  public User login(User user) throws UserException {
    User _user = userDao.findByUsername(user.getUsername());
    if(_user == null ){
      throw new UserException("用户名不存在");
    }
    if(!_user.getPassword().equals(user.getPassword())){
      throw  new  UserException("用户名密码错误");
    }
    return _user;
  }
}
