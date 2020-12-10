package com.service.Impl;

import com.dao.BillAndProDao;
import com.dao.impl.BillAndProImpl;
import com.pojo.Bill;
import com.service.BillAndProService;
import com.utils.BaseDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author tdragon.
 * @Date 2020/12/7.
 * @Time 14:39
 * @Description:
 */

public class BillAndProServiceImpl extends BaseDao implements BillAndProService {
    BillAndProDao billAndProDao=new BillAndProImpl();
    @Override
    public List<Bill> showBillAndProvider(int pageNo, int pageSize) throws Exception {
        return billAndProDao.showBillAndProvider(pageNo,pageSize);
    }

    @Override
    public int getTotalCount(String name) throws Exception {
        return billAndProDao.getTotalCount(name);
    }

    @Override
    public int addBill(Bill bill) throws Exception {
        return billAndProDao.addBill(bill);
    }

    @Override
    public Bill getBillById(int id) throws Exception {
        return billAndProDao.getBillById(id);
    }

    @Override
    public int updateBill(Bill bill) throws Exception {
        return billAndProDao.updateBill(bill);
    }

    @Override
    public int deleteBill(int id) throws Exception {
        return billAndProDao.deleteBill(id);
    }

    @Override
    public List<Bill> showBillByName(Bill bill, int pageNo, int pageSize) throws SQLException {
        return billAndProDao.showBillByName(bill,pageNo,pageSize);
    }
}
