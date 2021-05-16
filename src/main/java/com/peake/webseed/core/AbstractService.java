package com.peake.webseed.core;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.peake.webseed.common.redis.CacheService;
import com.peake.webseed.feature.admin.model.Admin;
import com.peake.webseed.feature.member.service.MemberPlusService;
import com.peake.webseed.utils.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractService<T> implements Service<T> {

    @Autowired
    protected Mapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    @Autowired
    CacheService cacheService;
    @Autowired
    MemberPlusService memberPlusService;


    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public void save(T model) {
        mapper.insertSelective(model);
    }

    public void save(List<T> models) {
        mapper.insertList(models);
    }

    public void deleteById(Long id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }

    public void update(T model) {
        mapper.updateByPrimaryKeySelective(model);
    }

    public T findById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    public List<T> findByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }

    public List<T> findAll() {
        return mapper.selectAll();
    }

    public List<T> findByExample(Object o) {
        return mapper.selectByExample(o);
    }

    @Override
    public PageInfo findbyPage(Integer page, Integer size, String orderby, T o) {
        Example example = new Example(Admin.class);
        example.createCriteria().andNotEqualTo("dataStatus", -1);
        example.orderBy(orderby);
        PageHelper.startPage(page, size);
        List<T> list = findByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public Date now(){
        return DateUtils.now();
    }

    protected Admin getAdmin(){
        return cacheService.getAdminInfo();
    }

    public PageInfo findbyCustomPage(Integer page, Integer size,T o){

        PageHelper.startPage(page, size);
        List<T> list = mapper.findByCustomCondition(o);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public List<T> findByCustomCondition(@Param("obj") T o){
        return mapper.findByCustomCondition(o);
    }
    @Override
    public PageInfo findMapByCustomPage(Integer page, Integer size, HashMap<String, Object> o) {
        PageHelper.startPage(page, size);
        List<Map<String,Object>> list = mapper.findMapByCustomPage(o);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public Result add(T model){
        return null;
    }

}
