package com.dao.impl;

import com.dao.BillAndProDao;
import com.pojo.Bill;
import com.pojo.Provider;
import com.utils.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author tdragon.
 * @Date 2020/12/7.
 * @Time 14:25
 * @Description:
 */

public class BillAndProImpl extends BaseDao implements BillAndProDao {
    @Override
    public List<Bill> showBillAndProvider(int pageNo, int pageSize) throws Exception {

        List<Bill> list=new ArrayList<>();
        String sql="select b.providerId as providerId,b.id as id, b.billCode as billCode,b.productName as productName,p.proName as proName,b.totalPrice as totalPrice,b.isPayment as isPayment,b.creationDate as creationDate from smbms_bill b inner join smbms_provider p " +
                "on b.providerId=p.id limit ?,?";
        Object[] params={(pageNo-1)*pageSize,pageSize};
        ResultSet rs=this.executeSQL(sql, params);
        while(rs.next()){
            int id=rs.getInt("id");
            String billCode=rs.getString("billCode");
            String productName=rs.getString("productName");
            String proName=rs.getString("proName");
            double totalPrice=rs.getDouble("totalPrice");
            int isPayment=rs.getInt("isPayment");
            Date creationDate=rs.getDate("creationDate");
            int providerId=rs.getInt("providerId");
            Bill bill=new Bill();
            Provider provider=new Provider();
            provider.setId(providerId);
            provider.setProName(proName);
            bill.setProvider(provider);
            bill.setId(id);
            bill.setBillCode(billCode);
            bill.setProductName(productName);
            bill.setTotalPrice(totalPrice);
            bill.setIsPayment(isPayment);
            bill.setCreationDate(creationDate);
            list.add(bill);
        }
        return list;
    }

    @Override
    public int getTotalCount(String name) throws Exception {
        int count=0;
        if(name==null) {
            String sql = "select count(*) from smbms_bill b inner join smbms_provider p on b.providerId=p.id";
            Object[] params = {};
            ResultSet rs = this.executeSQL(sql, params);
            while (rs.next()) {
                count = rs.getInt(1);
                System.out.println("账单总数量："+count);
            }
            return count;
        }else
            {
                String sql="select count(*) from smbms_bill b inner join smbms_provider p on b.providerId=p.id";
                StringBuilder sb=new StringBuilder();
                sb.append(sql);
                sb.append(" and productName like '%"+name+"%'");
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
    public int addBill(Bill bill) throws Exception {
        String sql = "insert into smbms_bill(id,billCode,productName,productDesc,productUnit,productCount,totalPrice,isPayment,creationDate,providerId) " +
                "values(?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {bill.getId(),bill.getBillCode(),bill.getProductName(),bill.getProductDesc(),bill.getProductUnit(),bill.getProductCount(),bill.getTotalPrice(),bill.getIsPayment(),bill.getCreationDate(),bill.getProvider().getId()};
        int count = this.executeUpdate(sql, params);
        return count;
    }

    @Override
    public Bill getBillById(int id) throws Exception {
        Bill bill=new Bill();
        String sql="select * from smbms_bill where id = ?";
        Object[] params={id};
        ResultSet rs= this.executeSQL(sql, params);
        while(rs.next()){
            Provider provider=new Provider();
            int providerId=rs.getInt("providerId");
            provider.setId(providerId);
            bill.setProvider(provider);
            bill.setId(rs.getInt("id"));
            bill.setBillCode(rs.getString("billCode"));
            bill.setProductName(rs.getString("productName"));
            bill.setProductCount(rs.getDouble("productCount"));
            bill.setTotalPrice(rs.getDouble("totalPrice"));
            bill.setIsPayment(rs.getInt("isPayment"));
            bill.setProductDesc(rs.getString("productDesc"));
            bill.setCreationDate(rs.getDate("creationDate"));
            bill.setProductUnit(rs.getString("productUnit"));
        }
        return bill;
    }

    @Override
    public int updateBill(Bill bill) throws Exception {
        String  sql = "update  smbms_bill set billCode=?,productName=?,productDesc=?,productUnit=?,productCount=?," +
                "totalPrice=?,isPayment=?,providerId=?,creationDate=? where id=?";
        Object[] params = {bill.getBillCode(),bill.getProductName(),bill.getProductDesc(),bill.getProductUnit(),bill.getProductCount(),bill.getTotalPrice(),bill.getIsPayment(),bill.getProvider().getId(),bill.getCreationDate(),bill.getId()};
        return this.executeUpdate(sql,params);
    }

    @Override
    public int deleteBill(int id) throws Exception {
        int count = 0;
        String sql = "delete from smbms_bill where  id = ?";
        Object[] params = {id};
        count = this.executeUpdate(sql,params);
        return count;
    }

    @Override
    public List<Bill> showBillByName(Bill bill, int pageNo, int pageSize) throws SQLException {
        List<Bill> bills=new ArrayList<>();
        String sql="select  * from smbms_provider inner join smbms_bill on smbms_bill.providerId=smbms_provider.id ";
        Object[] params={};
        StringBuilder sb=new StringBuilder();
        sb.append(sql);
        sb.append(" where productName like '%"+bill.getProductName()+"%'");
        sb.append(" limit "+(pageNo-1)*pageSize+","+pageSize+"");
        ResultSet rs=this.executeSQL(sb.toString(), params);
        while (rs.next()) {
            int id=rs.getInt("id");
            String billCode=rs.getString("billCode");
            String productName=rs.getString("productName");
            String proName=rs.getString("proName");
            double totalPrice=rs.getDouble("totalPrice");
            int isPayment=rs.getInt("isPayment");
            Date creationDate=rs.getDate("creationDate");
            int providerId=rs.getInt("providerId");
            Bill bil=new Bill();
            Provider provider=new Provider();
            provider.setId(providerId);
            provider.setProName(proName);
            bil.setProvider(provider);
            bil.setId(id);
            bil.setBillCode(billCode);
            bil.setProductName(productName);
            bil.setTotalPrice(totalPrice);
            bil.setIsPayment(isPayment);
            bil.setCreationDate(creationDate);
            bills.add(bil);
        }
        return bills;
    }
}
