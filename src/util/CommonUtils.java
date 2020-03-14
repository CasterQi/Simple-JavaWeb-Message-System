package util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;


public class CommonUtils{

  // 生成uuid
  public static String uuid(){
    return UUID.randomUUID().toString().replace("-", "");
  }

  public static <T> T toBan(Map map, Class<T> tClass){


    try{
      T t = tClass.newInstance(); // 创建泛型实例
      BeanUtils.populate(t, map); // 方法将页面各个属性映射到 t 中。之后我们就可以这样使用 t.getXxxx()来取值了。
      return t;
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
}
