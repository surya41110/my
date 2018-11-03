package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDeveloperDao;
import com.app.model.Developer;

@Repository
public class DeveloperDaoImpl implements IDeveloperDao {
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveDeveloper(Developer dev) {
		return (Integer) ht.save(dev);
	}

	@Override
	public void updateDeveloper(Developer dev) {
		ht.update(dev);
	}

	@Override
	public void deleteDeveloper(int devId) {
		Developer dev=new Developer();
		dev.setDevId(devId);
		ht.delete(dev);
	}

	@Override
	public Developer getOneDeveloper(Integer devId) {
		return ht.get(Developer.class, devId);
	}

	@Override
	public List<Developer> getAllDevelopers() {
		return ht.loadAll(Developer.class);
	}

}
