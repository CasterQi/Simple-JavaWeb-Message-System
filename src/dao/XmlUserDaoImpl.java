package dao;

import model.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;



public class XmlUserDaoImpl implements UserDao{
  String path= "/D:/D-java/javaLogin/web/table/user.xml";

  @Override
  public User findByUsername(String username){
    SAXReader reader=new SAXReader();

    try{
      Document document = reader.read(path);
      // 获取节点
      Element element= (Element) document.selectSingleNode("//user[@username='"+username+"']");

      if (element==null) return null;
      User user=new User();
      String uname=element.attributeValue("username");
      String password=element.attributeValue("password");
      user.setUsername(uname);
      user.setPassword(password);
      return user;
    }catch(DocumentException e){
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public void add(User user){
    SAXReader reader = new SAXReader();
    XMLWriter writer = null;


    try{
      Document document = reader.read(path);
      // 获取根节点
      Element rootElement = document.getRootElement();
      Element userElement = rootElement.addElement("user");
      userElement.addAttribute("username",user.getUsername());
      userElement.addAttribute("password",user.getPassword());

      OutputFormat format=new OutputFormat("\t",true);
      format.setTrimText(true);
      writer=new XMLWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"),format);
      writer.write(document);
      writer.flush();
      writer.close();
    }catch(Exception e){
      e.printStackTrace();
    }


  }
}
