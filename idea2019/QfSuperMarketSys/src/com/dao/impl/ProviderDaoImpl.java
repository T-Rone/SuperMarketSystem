package com.dao.impl;

import com.dao.ProviderDao;
import com.pojo.Provider;
import com.utils.BaseDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author tdragon.
 * @Date 2020/12/5.
 * @Time 14:26
 * @Description:
 */

public class ProviderDaoImpl extends BaseDao implements ProviderDao{
    @Override
    public List<Provider> showProvider(int pageNo,int pageSize) throws Exception {
        List<Provider> list=new ArrayList<Provider>();
        String sql="select * from smbms_provider limit ?,?";
        Object[] params={(pageNo-1)*pageSize,pageSize};
        ResultSet rs= this.executeSQL(sql, params);
        while(rs.next()){
            int id=rs.getInt("id");
            String proCode=rs.getString("proCode");
            String proName=rs.getString("proName");
            String proContact=rs.getString("proContact");
            String proPhone=rs.getString("proPhone");
            String proFax=rs.getString("proFax");
            Date creationDate=rs.getDate("creationDate");
            Provider provider=new Provider();
            provider.setId(id);
            provider.setProCode(proCode);
            provider.setProName(proName);
            provider.setProContact(proContact);
            provider.setProPhone(proPhone);
            provider.setProFax(proFax);
            provider.setCreationDate(creationDate);
            list.add(provider);

        }
        return list;
    }

    //通过id获取供应商信息
    @Override
    public Provider getProviderById(int id) throws Exception {
        Provider provider=new Provider();
        String sql="select * from smbms_provider where id=?";
        Object[] params={id};
        ResultSet rs= this.executeSQL(sql, params);
        while(rs.next()){
            String proCode=rs.getString("proCode");
            String proName=rs.getString("proName");
            String proContact=rs.getString("proContact");
            String proPhone=rs.getString("proPhone");
            String proFax=rs.getString("proFax");
            String proDesc=rs.getString("proDesc");
            Date creationDate=rs.getDate("creationDate");

            provider.setId(id);
            provider.setProCode(proCode);
            provider.setProName(proName);
            provider.setProContact(proContact);
            provider.setProPhone(proPhone);
            provider.setProFax(proFax);
            provider.setCreationDate(creationDate);
            provider.setProDesc(proDesc);

        }
        return provider;
    }

    @Override
    public List<Provider> showProviderByName(Provider provider, int pageNo, int pageSize) throws Exception {
        List<Provider> list=new ArrayList<>();
        String sql="select * from smbms_provider";
        Object[] params={};
        StringBuilder sb=new StringBuilder();
        sb.append(sql);
        sb.append(" where proName like '%"+provider.getProName()+"%'");
        sb.append(" limit "+(pageNo-1)*pageSize+","+pageSize+"");
        ResultSet rs=this.executeSQL(sb.toString(), params);
        while (rs.next()){
            int id=rs.getInt("id");
            String proCode=rs.getString("proCode");
            String proName=rs.getString("proName");
            String proDesc=rs.getString("proDesc");
            String proContact=rs.getString("proContact");
            String phone=rs.getString("proPhone");
            String proAddress=rs.getString("proAddress");
            String proFax=rs.getString("proFax");
            Date createdate= rs.getDate(9);
            //我嘛了  这里没写---的结果  模糊查询都一样的
            Provider provider1=new Provider();
            provider1.setProName(proName);
            provider1.setId(id);
            provider1.setProCode(proCode);
            provider1.setProDesc(proDesc);
            provider1.setProContact(proContact);
            provider1.setProPhone(phone);
            provider1.setProAddress(proAddress);
            provider1.setProFax(proFax);
            provider1.setCreationDate(createdate);
            list.add(provider1);
        }
        return list;
    }

    @Override
    public int addProvider(Provider provider) throws Exception {
        int count=0;
        String sql="insert into smbms_provider(proCode,proName,proDesc,proContact," +
                "proPhone,proAddress,proFax,creationDate)values(?,?,?,?,?,?,?,?)";
        Object[] params={provider.getProCode(),provider.getProName(),provider.getProDesc(),provider.getProContact(),provider.getProPhone(),
                provider.getProAddress(),provider.getProFax(),provider.getCreationDate()};
        count=this.executeUpdate(sql, params);
        return count;
    }

    @Override
    public int updateProvider(Provider provider) throws Exception {
        int count=0;
        String sql="update smbms_provider set proCode=?,proName=?,proDesc=?,proContact=?," +
                "proPhone=?,proAddress=?,proFax=?,creationDate=? where id=?";
        Object[] params={provider.getProCode(),provider.getProName(),provider.getProDesc(),provider.getProContact(),provider.getProPhone(),
                provider.getProAddress(),provider.getProFax(),provider.getCreationDate(),provider.getId()};
        count=this.executeUpdate(sql, params);
        return count;
    }

    //获取总个数
    @Override
    public int getTotalCount(String name) throws Exception {
        int count=0;
        if(name==null) {
            String sql="select count(*) from smbms_provider";
            Object[] params={};
            ResultSet rs=this.executeSQL(sql, params);
            while(rs.next()){
                count=rs.getInt(1);
                System.out.println("所有数量："+count);
            }
            return count;
        }
        else {
            String sql="select count(*) from smbms_provider";
            StringBuilder sb=new StringBuilder();
            sb.append(sql);
            sb.append(" where proName like '%"+name+"%'");
            Object[] params={};
            ResultSet rs=this.executeSQL(sb.toString(), params);
            while(rs.next()){
                count=rs.getInt(1);
                System.out.println("模糊总数量："+count);
            }
            return count;
        }
    }

    @Override
    public int deleteProvider(int id) throws Exception {
        int count=0;
        String sql="delete from smbms_provider where id=?";
        Object[] params={id};
        count=this.executeUpdate(sql, params);
        return count;
    }
}
