package com.shwl.navigation.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shwl.navigation.dao.ProjectDao;

@Controller("")
public class IndexControl {
	
	@Autowired
	private ProjectDao projectDao;
//	@RequestMapping("index")
//	public String index(Model model) {
//		System.out.println("index");
//		model.addAttribute("projectlist", projectDao.findAll());
//		return "index";
//	}
	@RequestMapping("")
	public String adminindex(Model model) {
		return "adminindex";
	}
	@RequestMapping("addcygj")
	public String addcygj(Model model) {
		return "addcygj";
	}
	@RequestMapping("sccgpage")
	public String cygjlist(Model model) {
		model.addAttribute("projectlist", projectDao.findAll());
		return "sccgpage";
	}
}
