package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Project;
import com.app.service.IProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private IProjectService service;
	
	@RequestMapping("/form")
	public String showForm(ModelMap map){
		map.addAttribute("proj", new Project());
		return "RegisterProject";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveProject(@ModelAttribute Project proj,ModelMap map){
		Integer projId=service.saveProject(proj);
		map.addAttribute("message", "Saved with "+ projId);
		map.addAttribute("proj",new Project());
		return "RegisterProject";
	}
	
	@RequestMapping("/edit")
	public String editForm(@RequestParam Integer projId,ModelMap map){
		Project proj=service.getOneProject(projId);
		map.addAttribute("proj", proj);
		return "UpdateProject";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateProject(@ModelAttribute Project proj,ModelMap map){
		service.updateProject(proj);
		map.addAttribute("message", "Updated with "+ proj.getProjId());
		List<Project> projs=service.getAllProject();
		map.addAttribute("projs", projs);
		return "ProjectsData";
	}
	@RequestMapping("/delete")
	public String deleteProject(@RequestParam int projId,ModelMap map){
		service.deleteProject(projId);
		map.addAttribute("message", "Deleted with "+ projId);
		List<Project> projs=service.getAllProject();
		map.addAttribute("projs", projs);
		return "ProjectsData";
	}
	@RequestMapping("/all")
	public String getProjects(ModelMap map){
		List<Project> projs=service.getAllProject();
		map.addAttribute("projs", projs);
		return "ProjectsData";
	}
}
