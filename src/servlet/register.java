package servlet;

import model.User;
import service.UserException;
import service.UserService;
import util.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "register")
public class register extends HttpServlet{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");

    User user = CommonUtils.toBan(request.getParameterMap(), User.class);

    //校验用户名、密码是否为空，长度要在3-15之间，验证码要正确
    Map<String,String> errors = new HashMap<>();
    String username =user.getUsername();
    if(username == null || username.trim().isEmpty()){
      errors.put("username","用户名不能为空");
    }else if(username.length()<3||username.length()>15){
      errors.put("username","用户名长度应在长度要在3-15之间");
    }

    String password = user.getPassword();
    if(password == null||password.trim().isEmpty()){
      errors.put("password","用户名密码不能为空");
    }else if(password.length()<3||password.length()>15){
      errors.put("password","密码长度应在长度要在3-15之间");
    }

    String verifyCode=user.getVerifyCode();
    String sessionVerifyCode=(String) request.getSession().getAttribute("session_vcode");
    if (verifyCode==null||verifyCode.trim().isEmpty())
    {
      errors.put("verifyCode","验证码不能为空");
    }else if (verifyCode.length()!=4)
    {
      errors.put("verifyCode","验证码长度应该在为4位");
    }else if (!sessionVerifyCode.equalsIgnoreCase(verifyCode))
    {
      errors.put("verifyCode","验证码错误");
    }



    if(errors!=null && errors.size()>0){
      request.setAttribute("errors",errors);
      request.setAttribute("user",user);
      request.getRequestDispatcher("/index/register.jsp").forward(request,response);
      return;

    }

    try{
      UserService userService = new UserService();

      userService.register(user);
      response.getWriter().println("<h1>注册成功</h1><a href='" + request.getContextPath() + "/index/index.jsp" + "'>点击这里去登录</a>");
    }catch(UserException e){
      request.setAttribute("user",user);
      request.setAttribute("msg",e.getMessage());
      request.getRequestDispatcher("/index/register.jsp").forward(request,response);
      //request.getRequestDispatcher("/index/register.jsp").forward(request,response);
    }
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    
  }
}
