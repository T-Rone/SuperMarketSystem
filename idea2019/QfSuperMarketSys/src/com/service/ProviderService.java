package com.service;

import com.pojo.Provider;

import java.util.List;

/**
 * @Author tdragon.
 * @Date 2020/12/5.
 * @Time 14:33
 * @Description:
 */

public interface ProviderService {

    /**
     * 查询所有的供应商信息
     * @return
     * @throws Exception
     */
    List<Provider> showProvider(int pageNo, int pageSize) throws Exception;

    /**
     * 获取商品总数量
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

    List<Provider> showProviderByName(Provider provider, int pageNo, int pageSize) throws Exception;

    int addProvider(Provider provider) throws Exception;

    int updateProvider(Provider provider) throws Exception;

    public int deleteProvider(int id) throws Exception;
}
