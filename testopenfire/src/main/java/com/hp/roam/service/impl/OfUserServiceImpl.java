package com.hp.roam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.roam.dao.OfUserMapper;
import com.hp.roam.model.OfUser;
import com.hp.roam.service.OfUserService;

/**
 * @author ck
 * @date 2019年3月14日 下午12:41:04
 */
@Service
@Transactional
public class OfUserServiceImpl implements OfUserService {

	@Autowired
	private OfUserMapper ofUserMapper;
	
	@Override
	public List<OfUser> selectAll() {
		return ofUserMapper.selectByExample(null);
	}

}
