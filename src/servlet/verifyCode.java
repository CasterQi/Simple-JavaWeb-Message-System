package servlet;

import util.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;


@WebServlet(name = "verifyCode")
public class verifyCode extends HttpServlet{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    doGet(request,response);
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    VerifyCode verifyCode = new VerifyCode();
    BufferedImage bufferedImage = verifyCode.getImage();
    request.getSession().setAttribute("session_vcode",verifyCode.getText());
    VerifyCode.output(bufferedImage,response.getOutputStream());
  }
}
