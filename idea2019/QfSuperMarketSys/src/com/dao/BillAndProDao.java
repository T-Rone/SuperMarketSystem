package com.dao;

/**
 * @Author tdragon.
 * @Date 2020/12/7.
 * @Time 14:23
 * @Description:
 */

import com.pojo.Bill;

import java.sql.SQLException;
import java.util.List;

public interface BillAndProDao {
    /**
     * 分页查询信息
     * @return
     * @throws Exception
     */
    List<Bill> showBillAndProvider(int pageNo, int pageSize) throws Exception;

    /**
     * 获取总数量
     * @return
     * @param
     * @throws Exception
     */
    int getTotalCount(String name) throws Exception;


    /**
     * 添加账单
     * @param bill
     */

    int addBill(Bill bill) throws  Exception;

    /**
     * @param id
     *id查看信息
     */
     Bill getBillById(int id) throws  Exception;

    /**
     * 更新
     * @param bill
     * @return
     * @throws Exception
     */
     int updateBill(Bill bill) throws Exception;

    /**
     * 通过id删除
     * @param id
     * @return
     * @throws Exception
     */
    int deleteBill(int id) throws Exception;

    List<Bill> showBillByName(Bill bill, int pageNo, int pageSize) throws SQLException;
}
