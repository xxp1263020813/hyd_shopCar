package cn.edu.zut.DAO;

import cn.edu.zut.DO.UserDO;

/**
 * 用户数据基本访问类
 */
public interface UserDAO {
    /**
     * 根据用户名获得一个用户的基本信息
     * @param username
     * @return
     */
    public UserDO getUserDO(String username);


}
