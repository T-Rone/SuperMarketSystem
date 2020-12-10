package com.service;

import com.pojo.Bill;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author tdragon.
 * @Date 2020/12/7.
 * @Time 14:37
 * @Description:
 */

public interface BillAndProService {

    /**
     * 所有数据的分页
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
     List<Bill> showBillAndProvider(int pageNo, int pageSize) throws Exception;

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
