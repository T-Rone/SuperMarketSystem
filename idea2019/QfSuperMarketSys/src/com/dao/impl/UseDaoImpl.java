package com.dao.impl;

import com.dao.UseDao;
import com.pojo.User;
import com.utils.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author tdragon.
 * @Date 2020/11/28.
 * @Time 10:08
 * @Description:
 */

public class UseDaoImpl extends BaseDao implements UseDao {
    @Override
    public boolean loginUser(User user) throws Exception {
        boolean falg=false;
        String sql="select * from smbms_user where userName=? and userPassword=?";
        Object[] params={user.getUserName(),user.getUserPassword()};
        ResultSet rs=this.executeSQL(sql, params);
        while(rs.next()){
            falg=true;
        }
        return falg;
    }

    @Override
    public int getTotalCount() throws Exception {
        int count=0;
        String sql="select count(*) from smbms_user";
        Object[] params={};
        StringBuilder sb=new StringBuilder();
//        if(name==null){
//            sb.append(sql);
//        }
//        else
//            {
            sb.append(sql);
//            sb.append(" where userName like '%"+name+"%'");
//        }
        ResultSet rs=this.executeSQL(sb.toString(), params);
        while(rs.next()){
            count=rs.getInt(1);
        }
        return count;
    }
    @Override
    public List<User> showList(int pageNo, int pageSize) throws Exception {
        List<User> list=new ArrayList<>();
        String sql="select * from smbms_user";
        Object[] params={};
        StringBuilder sb=new StringBuilder();
//        if(user==null){
            sb.append(sql);
            sb.append(" limit "+(pageNo-1)*pageSize+","+pageSize+"");
//        }
//        else{
//            sb.append(sql);
//            sb.append(" where userName like '%"+user.getUserName()+"%'");
//            sb.append(" limit "+(pageNo-1)*pageSize+","+pageSize+"");
//        }
        ResultSet rs=this.executeSQL(sb.toString(), params);
        while(rs.next()){
            int id=rs.getInt("id");
            String userCode=rs.getString("userCode");
            String userName=rs.getString("userName");
            String address=rs.getString(9);
            int gender=rs.getInt("gender");
            int age=rs.getInt("age");
            String phone=rs.getString("phone");
            int userRole=rs.getInt("userRole");
            User u=new User();
            u.setId(id);
            u.setUserCode(userCode);
            u.setUserName(userName);
            u.setGender(gender);
            u.setAge(age);
            u.setPhone(phone);
            u.setUserRole(userRole);
            u.setAddress(address);
            list.add(u);
        }
        return list;
    }

    @Override
    public int getTotalCountByName(User user) throws Exception {
        int count=0;
        String sql="select count(*) from smbms_user ";
        Object[] params={};
        StringBuilder sb=new StringBuilder();
        sb.append(sql).append(" where userName like '%"+user.getUserName()+"%'");
        ResultSet rs=this.executeSQL(sb.toString(), params);
        while(rs.next()){
            count=rs.getInt(1);
        }
        return count;
    }

    @Override
    public List<User> showListByName(User user,int pageNo, int pageSize) throws Exception {
        List<User> list=new ArrayList<>();
        String sql="select * from smbms_user";
        Object[] params={};
        StringBuilder sb=new StringBuilder();
        sb.append(sql);
        sb.append(" where userName like '%"+user.getUserName()+"%'");
        sb.append(" limit "+(pageNo-1)*pageSize+","+pageSize+"");
        ResultSet rs=this.executeSQL(sb.toString(), params);
        while(rs.next()){
            int id=rs.getInt("id");
            String userCode=rs.getString("userCode");
            String userName=rs.getString("userName");
            int gender=rs.getInt("gender");
            int age=rs.getInt("age");
            String phone=rs.getString("phone");
            int userRole=rs.getInt("userRole");
            User u=new User();
            u.setId(id);
            u.setUserCode(userCode);
            u.setUserName(userName);
            u.setGender(gender);
            u.setAge(age);
            u.setPhone(phone);
            u.setUserRole(userRole);
            list.add(u);
        }
        return list;
    }

    @Override
    public int addUser(User user) throws Exception {
        //增加
            int count=0;
            String sql="insert into smbms_user(userCode,userName,userPassword,age,gender,birthday,phone,address,userRole,creationDate)values(?,?,?,?,?,?,?,?,?,?)";
            Object[] params={user.getUserCode(),user.getUserName(),user.getUserPassword(),user.getAge(),user.getGender(),user.getBirthday(),user.getPhone(),user.getAddress(),user.getUserRole(),user.getCreationDate()};
            count=this.executeUpdate(sql, params);
            return count;
    }

    //通过id查询用户信息
    @Override
    public User getUserById(int id) throws Exception {
        User user=new User();
        String sql="select * from smbms_user where id=?";
        Object[] params={id};
        ResultSet rs=this.executeSQL(sql, params);
        while(rs.next()){
            String userCode=rs.getString("userCode");
            String userName=rs.getString("userName");
            int gender=rs.getInt("gender");
            Date birthday=rs.getDate("birthday");
            String phone=rs.getString("phone");
            String address=rs.getString("address");
            int userRole=rs.getInt("userRole");
            user.setId(id);
            user.setUserCode(userCode);
            user.setUserName(userName);
            user.setGender(gender);
            user.setBirthday(birthday);
            user.setPhone(phone);
            user.setAddress(address);
            user.setUserRole(userRole);
        }
        return user;
    }

    //通过id删除用户信息
    @Override
    public int deleteUser(int id) throws Exception {
        int count=0;
        String sql="delete from smbms_user where id=?";
        Object[] params={id};
        count=this.executeUpdate(sql, params);
        return count;
    }

    //修改
    @Override
    public int updateUser(User user) throws Exception {
        int count=0;
        String sql="update smbms_user set userName=?,gender=?,birthday=?,phone=?,address=?,userRole=? where id=?";
        Object[] params={user.getUserName(),user.getGender(),user.getBirthday(),user.getPhone(),user.getAddress(),user.getUserRole(),user.getId()};
        count=this.executeUpdate(sql, params);
        return count;
    }

    @Override
    public void updatePassword(User user) {
            String sql="update smbms_user set userPassword=?  where userName=?";
            Object[] params={user.getUserPassword(),user.getUserName()};
            if(this.executeUpdate(sql,params)>0){
                System.out.println("更新密码成功！");
            }
            else {
                System.out.println("出错了呢！");
            }

    }

    public static void main(String[] args) throws Exception {
        UseDao useDao=new UseDaoImpl();
        User user=new User();
        user.setUserName("admin");user.setUserPassword("0000000");
        System.out.println(useDao.loginUser(user)+"  "+useDao.getTotalCount());
        System.out.println(useDao.showList(2,4));
    }
}
