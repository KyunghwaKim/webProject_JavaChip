package controller.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.EstimateBoard;
import model.domain.ProductDetail;
import model.service.ProductService;

public class SelectProductInfoController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prodId = request.getParameter("prodId");
		
		if(prodId==null||prodId.equals("")) {
			throw new NotFoundException("�������� �ʴ� ��ǰ��ȣ�Դϴ�.");
		}
		
		Map<ProductDetail, EstimateBoard> map = ProductService.selectProdInfo(prodId);
		
		System.out.println(map + "map");
		List<EstimateBoard> estList = new ArrayList<EstimateBoard>();
		EstimateBoard estimate = null;
		int aveGrade = 0;
		int count = 0;
		
		for(ProductDetail key : map.keySet()) {	
			request.setAttribute("prodDetail", key);
			request.setAttribute("salePrice", (int)(key.getProduct().getPrice()*1.1));
			estimate = map.get(key);
			aveGrade += estimate.getGrade();
			if(count<3) {
				estList.add(estimate);	//�����򰡴� 3���� �ѷ��ش�
			}
			count++;
		}

		request.setAttribute("estimateList", estList);
		
		request.setAttribute("aveGrade", aveGrade/count);
		request.setAttribute("whiteStar", 5-aveGrade/count);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("detail_information/detail.jsp");
		 
		return mv; 
	}

}
