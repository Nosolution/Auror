package org.seec.muggle.auror.dao;

/**
 * 数据库增删改查基本接口
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/4/8
 */
public interface BaseOperation<T> {
    /**
     * 插入新记录
     *
     * @param t 新增记录
     * @return 影响行数
     */
    int insert(T t);

    /**
     * 更新记录
     *
     * @param t 新增记录
     * @return 影响行数
     */
    int update(T t);

    /**
     * 查找记录
     *
     * @param id 记录id
     * @return 影响行数
     */
    T get(Integer id);

    /**
     * 删除记录
     *
     * @param id 记录id
     * @return 影响行数
     */
    T delete(Integer id);
}
