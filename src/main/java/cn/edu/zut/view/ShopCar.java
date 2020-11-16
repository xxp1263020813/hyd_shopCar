package cn.edu.zut.view;

import cn.edu.zut.DO.AuctionDO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "shopCarView",urlPatterns = "/shopCarView")
public class ShopCar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        //生成响应页面
        response.setContentType("text/html;charset=utf-8");

        StringBuffer html = new StringBuffer();

        html.append("<html><head><title>auctionList</title></head>")
                .append("<body>")
                .append("<table><tr>")
                .append("<td>商品名称</td>")
                .append("<td>商品价格</td>")
                .append("</tr>");

        Enumeration<String> enumeration = request.getSession().getAttributeNames();

        List<AuctionDO > list = new ArrayList<>();
        while (enumeration.hasMoreElements()) {
            // 获取session键值
            String name = enumeration.nextElement().toString();
            // 根据键值取session中的值
            String price = (String) request.getSession().getAttribute(name);
            System.out.println(name+price);
            // 打印结果
            if ("username"!=name){
                list.add(new AuctionDO(0,name,Float.parseFloat(price),"0"));
            }
        }
        html.append("<tr>")
                .append("<button><a href=\"#\">购物车</a></button>")
                .append("<tr>")
                .append("<tr>");
        for(int i=0;i<list.size();i++){
            String str = ""+"deleteShopCar?name="+list.get(i).getTitle()+"&"+"price="+list.get(i).getPrice();
            html.append("<tr>")
                    .append("<tr>")
                    .append("<tr>")
                    .append("<td>").append(list.get(i).getTitle()).append("</td>")
                    .append("<td>").append(list.get(i).getPrice()).append("</td>")
                    .append("<td><button><a href=\""+str+"\">删除</a></button></td>")
                    .append("</tr>");
        }
        html.append("<td><button><a href=\"allAuction\">菜单</a></button></td>");
        html.append("</table></body></html>");
        response.getWriter().println(html.toString());
        response.getWriter().flush();
    }
}
