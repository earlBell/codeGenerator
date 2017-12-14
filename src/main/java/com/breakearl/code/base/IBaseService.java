package com.breakearl.code.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 通用接口
 * Created by earl on 2017/4/12.
 */
public interface IBaseService<T,PK> {

    Logger log = LoggerFactory.getLogger(IBaseService.class);

    int deleteByPrimaryKey(PK id);

    int insert(T record);
    int insertSelective(T record);

    T selectByPrimaryKey(PK id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    List<T> select(T record);

    T selectOne(T record);

    int selectCount(T record);

}
