package controller.teacher;

import java.util.List; 


import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
 
import controller.Controller; 
import controller.ModelAndView; 
import model.domain.Teacher; 
import model.service.TeacherService; 
 

public class selectByNameTeacherController {
	
 	 
 	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response, String name) throws Exception { 
		
 		Teacher list = TeacherService.selectByName(name); 
 		 
 		request.setAttribute("list", list); 
 		 
 		ModelAndView mv = new ModelAndView(); 
 		mv.setViewName(""); 
		 
 		return mv; 
 	} 

}

