package com.hp.roam.universal;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.entity.Condition;

/**
 * @Description: 基于通用MyBatis Mapper插件的Service接口的实现
 * @author ck
 * @date 2018年5月30日 下午3:10:31
 */
public abstract class AbstractService<T> implements Service<T>{

	@Autowired
	private Mapper<T> mapper;
	
	//当前泛型真实类型的Class
	private Class<T> modelClass;
	
	
	@SuppressWarnings("unchecked")
	public AbstractService() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		modelClass = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Override
	public Integer insert(T model) {
		return mapper.insert(model);
	}
	
	@Override
	public Integer insertList(List<T> list) {
		return mapper.insertList(list);
	}

	@Override
	public Integer deleteById(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer deleteByIds(String ids) {
		return mapper.deleteByIds(ids);
	}
	
	@Override
	public Integer update(T model) {
		return mapper.updateByPrimaryKeySelective(model);
	}
	
	public Integer updateSelectiveBy(T model,Condition condition){
		return mapper.updateByConditionSelective(model, condition);
	}

	@Override
	public T selectById(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public T selectBy(String fieldName, Object value)
			throws TooManyResultsException {
		try {
			T model = modelClass.newInstance();
			Field field = model.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(model, value);
			return mapper.selectOne(model);
		} catch (ReflectiveOperationException e) {
	         e.printStackTrace();
	      }
		return null;
	}

	@Override
	public List<T> selectListBy(String fieldName, Object value) {
		try {
			T model = modelClass.newInstance();
			Field field = model.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(model, value);
			return mapper.select(model);
		} catch (InstantiationException | IllegalAccessException
				| NoSuchFieldException | SecurityException
				| IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<T> selectListByIds(String ids) {
		return mapper.selectByIds(ids);
	}

	@Override
	public List<T> selectByCondition(Condition condition) {
		return mapper.selectByCondition(condition);
	}

	@Override
	public List<T> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public List<T> select(T record) {
		return mapper.select(record);
	}

	@Override
	public T selectOne(T record) {
		return mapper.selectOne(record);
	}

	public int updateByConditionSelective(T record,Condition condition){
		return mapper.updateByConditionSelective(record, condition);
	}
}
