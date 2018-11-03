package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDeveloperDao;
import com.app.model.Developer;
import com.app.model.Project;
import com.app.service.IDeveloperService;

@Service
public class DeveloperServiceImpl implements IDeveloperService{
	
	@Autowired
	private IDeveloperDao dao;

	@Override
	@Transactional
	public Integer saveDeveloper(Developer dev) {
		return dao.saveDeveloper(dev);
	}

	@Override
	@Transactional
	public void updateDeveloper(Developer dev) {
		dao.updateDeveloper(dev);
	}

	@Override
	@Transactional
	public void deleteDeveloper(int devId) {
		dao.deleteDeveloper(devId);
	}

	@Override
	@Transactional(readOnly=true)
	public Developer getOneDeveloper(Integer devId) {
		return dao.getOneDeveloper(devId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Developer> getAllDevelopers() {
		return dao.getAllDevelopers();
	}

}
