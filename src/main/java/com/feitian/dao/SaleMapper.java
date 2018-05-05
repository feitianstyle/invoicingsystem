package com.feitian.dao;

import com.feitian.model.PageInfo;
import com.feitian.model.Sale;
import com.feitian.model.SaleInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: feitian
 * @Date: 2018-05-03  9:57
 * @description:
 */
@Repository
public interface SaleMapper {
    Integer save(@Param("sale") Sale sale);
    int getCount();
    List<SaleInfo> findByPage(@Param("pageInfo") PageInfo pageInfo,@Param("sort") String sort);
}