package com.service.Impl;

import com.dao.ProviderDao;
import com.dao.impl.ProviderDaoImpl;
import com.pojo.Provider;
import com.service.ProviderService;
import com.utils.BaseDao;

import java.util.List;

/**
 * @Author tdragon.
 * @Date 2020/12/5.
 * @Time 14:35
 * @Description:
 */

public class ProviderServiceImpl extends BaseDao implements ProviderService {
    private ProviderDao providerDao=new ProviderDaoImpl();

    @Override
    public List<Provider> showProvider(int pageNo, int pageSize) throws Exception {
        return providerDao.showProvider(pageNo,pageSize);
    }

    @Override
    public Provider getProviderById(int id) throws Exception {
        return providerDao.getProviderById(id);
    }

    @Override
    public List<Provider> showProviderByName(Provider provider, int pageNo, int pageSize) throws Exception {
        return providerDao.showProviderByName(provider,pageNo,pageSize);
    }

    @Override
    public int addProvider(Provider provider) throws Exception {
        return providerDao.addProvider(provider);
    }

    @Override
    public int updateProvider(Provider provider) throws Exception {
        return providerDao.updateProvider(provider);
    }

    @Override
    public int getTotalCount(String name) throws Exception {
        return providerDao.getTotalCount(name);
    }

    @Override
    public int deleteProvider(int id) throws Exception {
        return providerDao.deleteProvider(id);
    }
}
