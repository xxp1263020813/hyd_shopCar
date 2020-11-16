package cn.edu.zut.view;

import cn.edu.zut.DO.AuctionDO;
import cn.edu.zut.service.AuctionService;
import cn.edu.zut.service.impl.AuctionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AuctionView",urlPatterns = "/auctionListView")
public class AuctionView extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        AuctionService auctionService = new AuctionServiceImpl() ;
        List<AuctionDO> list = auctionService.getAllAuction();
        //生成响应页面
        response.setContentType("text/html;charset=utf-8");
        StringBuffer html = new StringBuffer();
        html.append("<tr>")
                .append("<button><a href=\"#\">菜单</a></button>")
                .append("<tr>")
                .append("<tr>");

        html.append("<html><head><title>auctionList</title></head>")
                .append("<body>")
                .append("<table><tr>")
                .append("<td>商品名称</td>")
                .append("<td>商品价格</td>")
                .append("</tr>");
        for(int i=0;i<list.size();i++){
            String str = ""+"addShopCar?name="+list.get(i).getTitle()+"&"+"price="+list.get(i).getPrice();
            html.append("<tr>")
                    .append("<td>").append(list.get(i).getTitle()).append("</td>")
                    .append("<td>").append(list.get(i).getPrice()).append("</td>")
//                    .append("<td><button><a href=\"#\">加入购物车</a></button></td>")
                    .append("<td><button><a href=\""+str+"\">加入购物车</a></button></td>")
                    .append("</tr>");
        }

        html.append("<td><button><a href=\"shopCarView\">购物车</a></button></td>");
        html.append("</table></body></html>");
        response.getWriter().println(html.toString());
        response.getWriter().flush();
    }
}
