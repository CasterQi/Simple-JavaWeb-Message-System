package servlet;

import model.User;
import service.UserException;
import service.UserService;
import util.CommonUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class login extends HttpServlet{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException{

    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");

    /*
     * 获取表单数据，将用户名在数据库中查找
     * 1.成功，比较得到的密码和表单中的密码是否一样，一样则成功，不一样则返回密码错误信息
     * 2.失败，返回用户名错误的信息
     */

    User user = CommonUtils.toBan(request.getParameterMap(),User.class);
    UserService userService = new UserService();

    try{
      User suser = userService.login(user);
      request.getSession().setAttribute("sessionUser",suser);
      response.sendRedirect(request.getContextPath()+"/index/index.jsp");
    }catch(UserException e){
      request.setAttribute("user",user);
      request.setAttribute("msg",e.getMessage());
      request.getRequestDispatcher("/index/login.jsp").forward(request,response);
    }

  }
  
  protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{
    
  }
}
