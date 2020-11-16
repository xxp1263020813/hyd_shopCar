package cn.edu.zut.controller;

import cn.edu.zut.DO.ResultDO;
import cn.edu.zut.DO.UserDO;
import cn.edu.zut.service.UserService;
import cn.edu.zut.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ServletLogin" ,urlPatterns = "/Login")
public class ServletLogin extends HttpServlet {


    UserService userService = new UserServiceImpl();

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户传过来的用户名和密码
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        //通过以前写的登录判断语句，进行登录校验
        ResultDO<UserDO> result = userService.login(username,password);

        response.setContentType("text/html;charset=utf-8");
        if(result.isStatus()){

            HttpSession session = request.getSession();
            session.setAttribute("username",username);

            request.getRequestDispatcher("/allAuction").forward(request,response);

        }else{
            System.out.println(result.getInfo());
            response.sendRedirect("login?error="+new String(result.getInfo().getBytes(),"utf-8"));
        }

    }
}
