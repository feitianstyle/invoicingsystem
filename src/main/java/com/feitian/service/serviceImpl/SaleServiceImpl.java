package com.feitian.service.serviceImpl;

import com.feitian.dao.SaleMapper;
import com.feitian.model.PageInfo;
import com.feitian.model.Sale;
import com.feitian.model.SaleInfo;
import com.feitian.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: feitian
 * @Date: 2018-05-03  10:00
 * @description:
 */
@Service("saleService")
public class SaleServiceImpl implements SaleService {

    @Autowired
    SaleMapper saleMapper;
    @Override
    public Integer save(Sale sale) {
        Integer num = saleMapper.save(sale);
        return num;
    }

    @Override
    public int getCount() {
        return saleMapper.getCount();
    }

    @Override
    public List<SaleInfo> findByPage(PageInfo pageInfo,String sort) {
        return saleMapper.findByPage(pageInfo,sort);
    }
}