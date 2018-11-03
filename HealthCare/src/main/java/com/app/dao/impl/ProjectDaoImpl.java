package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IProjectDao;
import com.app.model.Project;

@Repository
public class ProjectDaoImpl implements IProjectDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveProject(Project proj) {
		return (Integer) ht.save(proj);
	}

	@Override
	public void updateProject(Project proj) {
		ht.update(proj);
	}

	@Override
	public void deleteProject(int projId) {
		Project proj = new Project();
		proj.setProjId(projId);
		ht.delete(proj);
	}

	@Override
	public Project getOneProject(Integer projId) {
		return ht.get(Project.class, projId);
	}

	@Override
	public List<Project> getAllProject() {
		return ht.loadAll(Project.class);
	}

}
