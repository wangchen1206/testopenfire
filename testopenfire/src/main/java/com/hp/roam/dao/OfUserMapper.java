package com.hp.roam.dao;

import com.hp.roam.model.OfUser;
import com.hp.roam.model.OfUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OfUserMapper {
    long countByExample(OfUserExample example);

    int deleteByExample(OfUserExample example);

    int deleteByPrimaryKey(String username);

    int insert(OfUser record);

    int insertSelective(OfUser record);

    List<OfUser> selectByExample(OfUserExample example);

    OfUser selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") OfUser record, @Param("example") OfUserExample example);

    int updateByExample(@Param("record") OfUser record, @Param("example") OfUserExample example);

    int updateByPrimaryKeySelective(OfUser record);

    int updateByPrimaryKey(OfUser record);
}