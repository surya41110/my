package com.app.service;

import java.util.List;

import com.app.model.Developer;
import com.app.model.Project;

public interface IDeveloperService {
	public Integer saveDeveloper(Developer dev);
	public void updateDeveloper(Developer dev);
	public void deleteDeveloper(int devId);
	public Developer getOneDeveloper(Integer devId);
	public List<Developer> getAllDevelopers();

}
