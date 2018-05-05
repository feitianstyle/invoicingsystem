package com.feitian.service;

import com.feitian.model.PageInfo;
import com.feitian.model.Sale;
import com.feitian.model.SaleInfo;

import java.util.List;

/**
 * @Author: feitian
 * @Date: 2018-05-03  9:59
 * @description:
 */
public interface SaleService{
    Integer save(Sale sale);
    int getCount();
    List<SaleInfo> findByPage(PageInfo pageInfo,String sort);
}