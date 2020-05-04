package controller.person;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import model.domain.Customer;
import model.service.CustomerService;
import model.service.PersonService;

public class SelectCustomerAllController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Customer> list = CustomerService.selectAll();
		List<Customer> resultlist = new ArrayList<Customer>();
		
		
		for(Customer c : list) {
			Date date = c.getRegDate();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String str = format.format(date);
			c.setUploadDateConvert(str);
			resultlist.add(c);
		}
		
		HttpSession session = request.getSession();
				
		session.setAttribute("resultlist", resultlist);
		
		ModelAndView mv = new ModelAndView(true, "Admin/userlist.jsp");
		
		return mv;
	}

}
