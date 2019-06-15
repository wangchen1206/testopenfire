package com.hp.roam.dao;

import com.hp.roam.model.SysUser;

/**
 * @author ck
 * @date 2019年2月27日 下午4:08:10
 */
public interface UserDao {

	public SysUser findByUserName(String username);
}
