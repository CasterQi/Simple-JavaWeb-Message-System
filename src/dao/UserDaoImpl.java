package dao;

import model.User;
import util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{


  @Override
  public User findByUsername(String username){
    Connection connection = null; // 数据库连接
    PreparedStatement preparedStatement = null; // 数据库操作
    ResultSet resultSet = null;
    User user = new User();
    try{
      connection = JdbcUtils.getConnection();
      String sql = "SELECT * FROM user WHERE username = ?";
      preparedStatement=connection.prepareStatement(sql);
      preparedStatement.setString(1,username);
      resultSet = preparedStatement.executeQuery();

      if(resultSet == null) return null;
      if (resultSet.next())
      {
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setAge(resultSet.getString("age"));
        user.setGender(resultSet.getString("gender"));
        return user;
      }


    }catch(SQLException e){
      e.printStackTrace();
    }finally{
       try{
         if (resultSet!=null) resultSet.close();
        if (preparedStatement!=null) preparedStatement.close();
        if (connection!=null) connection.close();
      }catch(SQLException e){
        e.printStackTrace();
      }

    }

    return null;
  }

  @Override
  public void add(User user){
    Connection connection=null;
    PreparedStatement ps=null;
    try {
      connection = JdbcUtils.getConnection();
      String sql="insert into User values(?,?,?,?)";
      ps=connection.prepareStatement(sql);
      ps.setString(1,user.getUsername());
      ps.setString(2,user.getPassword());
      ps.setString(3,user.getAge());
      ps.setString(4,user.getGender());
      ps.executeUpdate();
    }catch (Exception e)
    {
      throw new RuntimeException(e);
    }finally {
      try
      {
        if (ps!=null) ps.close();
        if (connection!=null) connection.close();
      }catch (Exception e)
      {
        throw new RuntimeException(e);
      }
    }
  }
}
