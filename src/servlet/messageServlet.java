package servlet;



import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Message;
import util.dbHelper;


@WebServlet("/servlet/messageServlet")
public class messageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public messageServlet() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = dbHelper.getConnection();
        if (request.getParameter("isQuery").equalsIgnoreCase("true") ) {
            String userName= request.getParameter("user");
            String sql = "select * from Message WHERE ReceiverName='"+userName+"' OR SenderName='"+userName+"'";
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                List<Message> messageList = new ArrayList<Message>();
                //Message message=new Message("","","","","");
                String sqlUpdate = "UPDATE Message SET ReadSign = 'Yes' WHERE ReceiverName = '"+userName+"' ";
                Statement st2 =conn.createStatement();
                st2.executeUpdate(sqlUpdate);
                while (rs.next()) {

                    Message message = new Message(rs.getString("note"), rs.getString("SenderName"), rs.getString("ReceiverName"), rs.getString("PostTime"), rs.getString("ReadSign"));
                    messageList.add(message);
                    //                message.setNote(rs.getString("note"));
//                message.setSenderName(rs.getString("SenderName"));
//                message.setReceiverName(rs.getString("ReceiverName"));
//                message.setPostTime(rs.getString("PostTime"));
//                message.setReadSign(rs.getString("ReadSign"));

                }
                //messageList.add(new Message("","","","",""));
                //将数据库中查询到的信息封装在user对象中，use对象保存在request中，之后将通过request对象将数据传递到页面
                //需要的话也可以只传递一个参数request.setAttribute("id", user.getId());
                request.setAttribute("message", messageList);
                //这里是转发，从Servlet跳转到showinfo.jsp页面，并且带上request和response对象中原有的参数
                request.getRequestDispatcher("../index/showMessageInfo.jsp").forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            String userName= request.getParameter("user");
            String note = "";
            String senderName = "";
            String receiverName = "";
            String postTime = "";
            String readSign = "";
//            if(request.getParameter(note)!="")note=request.getParameter(note);
//            if(request.getParameter(senderName)!="")senderName=request.getParameter(senderName);
//            if(request.getParameter(note)!="")note=request.getParameter(note);
//            if(request.getParameter(note)!="")note=request.getParameter(note);
//            if(request.getParameter(note)!="")note=request.getParameter(note);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            postTime=(df.format(new Date())).toString();
            System.out.println(df.format(new Date()));
            Message preInsertMessage=new Message(
                    request.getParameter("note"),
                    userName,
                    request.getParameter("receiverName"),
                    postTime,"No"
                    );

            String sql = "INSERT INTO Message VALUES ('" +
                    preInsertMessage.getNote() +"','"+
                    preInsertMessage.getSenderName() +"','"+
                    preInsertMessage.getReceiverName()+"','"+
                    preInsertMessage.getPostTime()+"','"+
                    preInsertMessage.getReadSign()+
                    "')";
            System.out.println(sql);
            try {
                Statement st = conn.createStatement();
                int result = st.executeUpdate(sql);
                //ResultSet rs = st.executeQuery(sql);
                //List<Message> messageList = new ArrayList<Message>();
                //Message message=new Message("","","","","");


                //messageList.add(new Message("","","","",""));
                //将数据库中查询到的信息封装在user对象中，use对象保存在request中，之后将通过request对象将数据传递到页面
                //需要的话也可以只传递一个参数request.setAttribute("id", user.getId());
                request.setAttribute("result",result);
                //这里是转发，从Servlet跳转到showinfo.jsp页面，并且带上request和response对象中原有的参数
                request.getRequestDispatcher("../index/insertResult.jsp").forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}