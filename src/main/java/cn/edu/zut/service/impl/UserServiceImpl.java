package cn.edu.zut.service.impl;

import cn.edu.zut.DAO.UserDAO;
import cn.edu.zut.DAO.impl.UserDAOImpl;
import cn.edu.zut.DO.ResultDO;
import cn.edu.zut.DO.UserDO;
import cn.edu.zut.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();
    @Override
    public ResultDO<UserDO> login(String username, String password) {
        ResultDO<UserDO> r = new ResultDO<>();
        if(password.trim() == null || "".equals(password.trim())){
            r.setInfo("用户密码不能为空");
            return r;
        }
        UserDO user = userDAO.getUserDO(username);
        if(user !=null){
            if (!user.getPassword().equals(password)){
                r.setInfo("密码不正确");
            }else{
                r.setStatus(true);
                r.setResult(user);
            }
        }else{
            r.setInfo("用户名不存在");
        }
        return r;
    }
}
