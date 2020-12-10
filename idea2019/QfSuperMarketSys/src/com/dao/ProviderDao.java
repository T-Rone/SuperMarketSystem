package com.dao;

import com.pojo.Provider;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author tdragon.
 * @Date 2020/12/5.
 * @Time 14:22
 * @Description: 数据库访问层
 */

public interface ProviderDao {
    /**
     * 分页查询所有的供应商信息
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Provider> showProvider(int pageNo, int pageSize) throws Exception;



    /**
     * 获取供应商总数量
     * @return
     * @throws Exception
     */
    public int getTotalCount(String name) throws Exception;


    /**
     * 通过id查询供应商信息
     * @param id
     * @return
     * @throws Exception
     */
    Provider getProviderById(int id) throws Exception;

    /**
     * 模糊分页
     */
    List<Provider> showProviderByName(Provider provider,int pageNo, int pageSize) throws Exception;

    /**
     * 添加供应商
     * @param provider
     * @return
     * @throws Exception
     */
    int addProvider(Provider provider) throws Exception;

    /**
     * 修改--
     * @param provider
     * @return
     * @throws Exception
     */
    int updateProvider(Provider provider) throws Exception;

    int deleteProvider(int id) throws Exception;
}
