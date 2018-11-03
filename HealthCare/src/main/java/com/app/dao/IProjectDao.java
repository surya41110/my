package com.app.dao;

import java.util.List;

import com.app.model.Project;

public interface IProjectDao {
	public Integer saveProject(Project proj);
	public void updateProject(Project proj);
	public void deleteProject(int projId);
	public Project getOneProject(Integer projId);
	public List<Project> getAllProject();

}
