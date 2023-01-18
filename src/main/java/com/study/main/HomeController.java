package com.study.main;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.main.departments.DepartmentDAO;
import com.study.main.departments.DepartmentDTO;
import com.study.main.locations.LocationDAO;
import com.study.main.locations.LocationDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("departments")
	public void getDepartments(Model model) throws Exception{
		DepartmentDAO deDAO = new DepartmentDAO();
		ArrayList<DepartmentDTO> deArr = deDAO.getList();
		model.addAttribute("list", deArr);
	}
	
	@RequestMapping("locations")
	public void getLocations(Model model) throws Exception{
		LocationDAO loDAO = new LocationDAO();
		ArrayList<LocationDTO> loArr = loDAO.getList();
		model.addAttribute("list", loArr);
	}

}
