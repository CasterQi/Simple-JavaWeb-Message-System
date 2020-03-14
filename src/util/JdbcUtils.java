package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcUtils{

  private static Properties properties = null;

  static{
    // 加载配置文件
    try{
      InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
      properties = new Properties();
      properties.load(inputStream);
    }catch(IOException e){
      e.printStackTrace();
    }

    try{
      Class.forName(properties.getProperty("driverClassName"));
    }catch(ClassNotFoundException e){
      e.printStackTrace();
    }

  }

  // 获取数据库连接
  public  static Connection getConnection() throws SQLException{

    return DriverManager.getConnection(properties.getProperty("url"),
                                       properties.getProperty("username"),
                                       properties.getProperty("password")
      );
  }

}
