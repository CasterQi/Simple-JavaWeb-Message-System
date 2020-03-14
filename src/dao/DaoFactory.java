package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DaoFactory{

  private static Properties properties = null;

  static{
    // 加载配置文件
    try{
      InputStream inputStream = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
      properties = new Properties();
      properties.load(inputStream);
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  // 创建一个工厂对象
  public static UserDao getUserDao(){
    /*
     *给出一个配置文件，文件中给出接口的实现类名称
     * 我们这个方法，获取实现类的类名，通过反射创建对象
     */
    try{
      Class cla = Class.forName(properties.getProperty("dao.UserDao"));
      return (UserDao) cla.newInstance();
    }catch(Exception e){
     e.printStackTrace();
    }
    return null;
  }

}
