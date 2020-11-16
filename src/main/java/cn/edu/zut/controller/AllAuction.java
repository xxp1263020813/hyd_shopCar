package cn.edu.zut.controller;

import cn.edu.zut.DO.AuctionDO;
import cn.edu.zut.service.AuctionService;
import cn.edu.zut.service.impl.AuctionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AllAuction",urlPatterns = "/allAuction")
public class AllAuction extends HttpServlet {
    AuctionService auctionService = new AuctionServiceImpl() ;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先判断是否登录

        if(request.getSession().getAttribute("username")!=null){
            List<AuctionDO> list = auctionService.getAllAuction();
            if(list==null){
                list = new ArrayList<>();
            }
            request.setAttribute("auctionList",list);
            request.getRequestDispatcher("/auctionListView").forward(request,response);

        }else{
            //否则，跳转回登录页面
            response.sendRedirect("login?error=用户名密码不正确");
        }



    }
}
