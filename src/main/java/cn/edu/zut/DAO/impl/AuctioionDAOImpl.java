package cn.edu.zut.DAO.impl;

import cn.edu.zut.DAO.AuctioionDAO;
import cn.edu.zut.DO.AuctionDO;
import cn.edu.zut.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuctioionDAOImpl implements AuctioionDAO {
    @Override
    public List<AuctionDO> getAllAuction() {
        //第一步获取数据库连接
        Connection conn = JDBCUtil.getConnction();
        String sql = "select * from auction ";//不能使用Statement==
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<AuctionDO> auctionDOS = new ArrayList<>();
        int i=0;
        try {
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                float price = rs.getFloat("price");
                String description = rs.getString("description");

                AuctionDO auctionDO = new AuctionDO(id, title, price, description);
                auctionDOS.add(auctionDO);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(rs,ps,conn);
        }
        return auctionDOS;
    }
}
