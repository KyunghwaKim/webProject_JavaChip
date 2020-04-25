package controller.product;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Category;
import model.domain.Product;
import model.domain.Teacher;
import model.service.ProductService;

public class UpdateProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		String id= request.getParameter("prod_id");
		String name= request.getParameter("prod_name");
		String price = request.getParameter("prod_price");
		String description = request.getParameter("description");
		String level = request.getParameter("prod_level");
		String teacher = request.getParameter("teacher_id");
		String category = request.getParameter("category_id");
		String uploadDate = request.getParameter("upload_date");
		String validate = request.getParameter("valid_Date");
		
		if(
				name==null || name.equals("") ||
				price==null || price.equals("") ||
				description==null || description.equals("") ||
				level==null || level.equals("") ||
				teacher==null || teacher.equals("") ||
				category==null || category.equals("") ||
				uploadDate==null || uploadDate.equals("") ) {
			throw new RuntimeException("입력값이 충분하지 않습니다..");
		}
		
		Category c = new Category();
		c.setId(Integer.parseInt(category));
		Teacher t = new Teacher();
		 t.setId(teacher);
		 
		 SimpleDateFormat date =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date fdate = date.parse(uploadDate);

		Product pro = new Product(id, name, 
				                         Integer.parseInt(price), 
				                         description, level,
				                         t, c,
				                         fdate,Integer.parseInt(validate) );


				ProductService.insert(pro);
				ModelAndView mv = new ModelAndView(true,"pro");
				return mv;
	}

}
