package com.hp.roam.universal;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * 通用Mapper不能被spring扫描到，否则会发生错误
 * @Description :定制版Mybatis插件接口，如需其他接口参考官方文档自行添加
 * @author ck
 * @date 2018年5月30日 下午2:58:00
 */
public interface Mapper<T> extends BaseMapper<T>, ConditionMapper<T>, IdsMapper<T>, InsertListMapper<T> {

}
