package com.service.Impl;

import com.dao.UseDao;
import com.dao.impl.UseDaoImpl;
import com.pojo.User;
import com.service.UserService;

import java.util.List;

/**
 * @Author tdragon.
 * @Date 2020/11/28.
 * @Time 11:35
 * @Description:
 */

public class UserServiceImpl  implements UserService {
    /**
     * 接口 new 实现类 多态
     */
    public UseDao useDao=new UseDaoImpl();
    @Override
    public boolean loginUser(User user) throws Exception {
        return useDao.loginUser(user);
    }

    @Override
    public int getTotalCount() throws Exception {
        return useDao.getTotalCount();
    }

    @Override
    public List<User> showList(int pageNo, int pageSize) throws Exception {
        return useDao.showList(pageNo,pageSize);
    }

    @Override
    public List<User> showListByName(User user, int pageNo, int pageSize) throws Exception {
        return useDao.showListByName(user,pageNo,pageSize);
    }

    @Override
    public int getTotalCountByName(User user) throws Exception {
        return useDao.getTotalCountByName(user);
    }

    //增加
    @Override
    public int addUser(User user) throws Exception {
        return useDao.addUser(user);
    }


    @Override
    public User getUserById(int id) throws Exception {
        return useDao.getUserById(id);
    }

    //通过id删除用户信息
    @Override
    public int deleteUser(int id) throws Exception {
        return useDao.deleteUser(id);
    }

    @Override
    public int updateUser(User user) throws Exception {
        return useDao.updateUser(user);
    }

    @Override
    public void updatePassword(User user) {
        useDao.updatePassword(user);
    }

}
