package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Developer;
import com.app.model.Project;
import com.app.service.IDeveloperService;
import com.app.service.IProjectService;

@Controller
@RequestMapping("/developer")
public class DeveloperController {
	@Autowired
	private IDeveloperService service;
	@Autowired
	private IProjectService projService;
	
	@RequestMapping("/form")
	public String showForm(ModelMap map){
		map.addAttribute("dev", new Developer());
		List<Project> projs=projService.getAllProject();
		map.addAttribute("projs", projs);
		return "RegisterDeveloper";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveDeveloper(@ModelAttribute Developer dev,ModelMap map){
		Integer devId=service.saveDeveloper(dev);
		map.addAttribute("message", "Saved with "+ devId);
		map.addAttribute("dev",new Developer());
		List<Project> projs=projService.getAllProject();
		map.addAttribute("projs", projs);
		return "RegisterDeveloper";
	}
	
	@RequestMapping("/edit")
	public String editForm(@RequestParam Integer devId,ModelMap map){
		Developer dev=service.getOneDeveloper(devId);
		map.addAttribute("dev", dev);
		List<Project> projs=projService.getAllProject();
		map.addAttribute("projs", projs);
		return "UpdateDeveloper";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateDeveloper(@ModelAttribute Developer dev,ModelMap map){
		service.updateDeveloper(dev);
		map.addAttribute("message", "Updated with "+ dev.getDevId());
		List<Developer> devs=service.getAllDevelopers();
		map.addAttribute("devs", devs);
		return "DevelopersData";
	}
	@RequestMapping("/delete")
	public String deleteDeveloper(@RequestParam int devId,ModelMap map){
		service.deleteDeveloper(devId);
		map.addAttribute("message", "Deleted with "+ devId);
		List<Developer> devs=service.getAllDevelopers();
		map.addAttribute("devs", devs);
		return "DevelopersData";
	}
	@RequestMapping("/all")
	public String getDevelopers(ModelMap map){
		List<Developer> devs=service.getAllDevelopers();
		map.addAttribute("devs", devs);
		return "DevelopersData";
	}
}
