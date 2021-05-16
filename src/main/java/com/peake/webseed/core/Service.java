package com.peake.webseed.core;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.HashMap;
import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 */
public interface Service<T> {
    void save(T model);//持久化
    void save(List<T> models);//批量持久化
    void deleteById(Long id);//通过主鍵刪除
    void deleteByIds(String ids);//批量刪除 eg：ids -> “1,2,3,4”
    void update(T model);//更新
    T findById(Long id);//通过ID查找
    T findBy(String fieldName, Object value) throws TooManyResultsException; //通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
    List<T> findByIds(String ids);//通过多个ID查找//eg：ids -> “1,2,3,4”
    List<T> findByCondition(Condition condition);//根据条件查找
    List<T> findAll();//获取所有
    List<T> findByExample(Object o);
    PageInfo findbyPage(Integer page, Integer size, String orderby, T o);
    PageInfo findbyCustomPage(Integer page, Integer size, T o);
    PageInfo findMapByCustomPage(Integer page, Integer size, HashMap<String,Object> o);
    Result add(T model);
    List<T> findByCustomCondition(@Param("obj") T o);
}
