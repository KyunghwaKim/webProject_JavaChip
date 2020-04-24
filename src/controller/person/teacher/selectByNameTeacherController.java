package controller.person.teacher;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
import controller.Controller; 
import controller.ModelAndView; 
import model.domain.Teacher; 
import model.service.TeacherService; 
 

public class selectByNameTeacherController implements Controller {
	@Override
 	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		String name = request.getParameter("name");
		
 		Teacher teacher = TeacherService.selectByName(name); 
 		 
 		request.setAttribute("teacher", teacher); 
 		 
 		ModelAndView mv = new ModelAndView(); 
 		mv.setViewName(""); 
		 
 		return mv; 
 	} 

}

