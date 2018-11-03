package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProjectDao;
import com.app.model.Project;
import com.app.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	private IProjectDao dao;
	
	@Override
	@Transactional
	public Integer saveProject(Project proj) {
		return dao.saveProject(proj);
	}

	@Override
	@Transactional
	public void updateProject(Project proj) {

		dao.updateProject(proj);
	}

	@Override
	@Transactional
	public void deleteProject(int projId) {
		dao.deleteProject(projId);
	}

	@Override
	@Transactional(readOnly=true)
	public Project getOneProject(Integer projId) {
		return dao.getOneProject(projId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Project> getAllProject() {
		return dao.getAllProject();
	}

}
