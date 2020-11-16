package cn.edu.zut.service;

import cn.edu.zut.DO.ResultDO;
import cn.edu.zut.DO.UserDO;

public interface UserService {

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public ResultDO<UserDO> login(String username, String password);

}
