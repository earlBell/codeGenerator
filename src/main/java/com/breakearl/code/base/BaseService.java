package com.breakearl.code.base;

import java.util.List;

public abstract class BaseService<T, PK> implements IBaseService<T, PK> {

    /**
     * 用子类返回的dao操作，具有通用性和支持事务
     */
    protected abstract IBaseMapper<T> getBaseDao();

    /**
     *  删除记录
     * @param id 主键
     */
    @Override
    public int deleteByPrimaryKey(PK id) {
        return getBaseDao().deleteByPrimaryKey(id);
    }

    /**
     *  删除记录
     * @param record 实体
     */
    public int delete(T record) {
        return getBaseDao().delete(record);
    }

    /**
     *  插入记录
     * @param record 实体
     */
    @Override
    public int insert(T record) {
        int total = getBaseDao().insert(record);
        return total;
    }
    /**
     *  精确插入记录
     */
    @Override
    public int insertSelective(T record) {
        return getBaseDao().insertSelective(record);
    }
    /**
     *  查询一条记录
     * @param id 主键
     */
    @Override
    public T selectByPrimaryKey(PK id) {
        return getBaseDao().selectByPrimaryKey(id);
    }

    /**
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(T record) {
        return getBaseDao().updateByPrimaryKeySelective(record);
    }
    /**
     * 更新记录
     * @param record 实体
     */
    @Override
    public int updateByPrimaryKey(T record) {
        return getBaseDao().updateByPrimaryKey(record);
    }

    /**
     *  根据属性条件进行查询
     * @param record 实体
     * @return List<T>
     */
    @Override
    public List<T> select(T record) {
        return getBaseDao().select(record);
    }

    @Override
    public T selectOne(T record) {
        return getBaseDao().selectOne(record);
    }

    @Override
    public int selectCount(T record) {
        return getBaseDao().selectCount(record);
    }

}
