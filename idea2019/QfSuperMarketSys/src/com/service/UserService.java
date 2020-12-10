package com.service;
import com.pojo.User;
import java.util.List;
/**
 * @Author tdragon.
 * @Date 2020/11/28.
 * @Time 10:29
 * @Description:
 */

public interface UserService {
    /**  login
     * 登录功能
     * @param user
     * @return boolean
     * @exception Exception
     */
    boolean loginUser(User user) throws Exception;

    /**
     * 获取用户总数量
     * @return
     * @throws Exception
     */
     int getTotalCount() throws Exception;

    /**
     * 模糊查询并分页   他这样写有问题(我试了的，点了用户管理实际上只显示第一页内容，点下一页，浏览器全白，但是没错，他得点模糊查询，才算分页
     * 用户名为空就是所有数据分页，不为空就是这个用户名字重复多少个分页 绝了这---)
     * 虽然想法是好的，分开写，用两个servlet，我这样代码也有些都问题就是 有重复的
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<User> showList(int pageNo, int pageSize) throws Exception;

    /**
     * 莫非我这才是模糊查询并分页
     * @param user
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<User> showListByName(User user,int pageNo, int pageSize) throws Exception;
    /**
     * 模糊查询的用户数量
     * @param user
     */
    int getTotalCountByName(User user) throws Exception;

    /**
     * 增加
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

    void updatePassword(User user);
}
