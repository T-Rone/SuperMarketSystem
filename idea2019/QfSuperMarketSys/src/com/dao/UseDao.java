package com.dao;

import com.pojo.User;
import java.sql.ResultSet;
import java.util.List;

/**
 * @Author tdragon.
 * @Date 2020/11/28.
 * @Time 10:07
 * @Description:
 */

public interface UseDao {
    /**
     * 登录功能
     * @param user
     * @return boolean
     * @throws Exception
     */
    boolean loginUser(User user) throws Exception;

    /**
     * 获取用户总数量
     * @return
     * @throws Exception
     */
    public int getTotalCount() throws Exception;

    /**
     * 分页
     * @param user
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<User> showList(int pageNo, int pageSize) throws Exception;

    /**
     * 模糊查询的用户数量
     * @param user
     */
    int getTotalCountByName(User user) throws Exception;

    List<User> showListByName(User user,int pageNo, int pageSize) throws Exception;
    /**
     * 增加功能
     * @param user
     * @return
     * @throws Exception
     */
    int addUser(User user) throws Exception;

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    User getUserById(int id) throws Exception;

    /**
     * 通过用户id删除用户信息
     * @param id
     * @return
     * @throws Exception
     */
    int deleteUser(int id) throws Exception;

    /**
     * 修改用户信息
     * @param user
     * @return
     * @throws Exception
     */
    int updateUser(User user) throws Exception;

    /**
     *
     * @param user
     */
    void updatePassword(User user);
}
