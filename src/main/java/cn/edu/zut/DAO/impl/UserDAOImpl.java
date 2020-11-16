package cn.edu.zut.DAO.impl;

import cn.edu.zut.DAO.UserDAO;
import cn.edu.zut.DO.UserDO;
import cn.edu.zut.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    @Override
    public UserDO getUserDO(String username) {
        //第一步获取数据库连接
        Connection conn = JDBCUtil.getConnction();
        String sql = "select * from user where username = ?";//不能使用Statement
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps =  conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();

            while(rs.next()){
                String usernamebyDB = rs.getString("username");
                String passwordbyDB = rs.getString("password");
                return new UserDO(usernamebyDB,passwordbyDB);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(rs,ps,conn);
        }
        return null;
    }

}
