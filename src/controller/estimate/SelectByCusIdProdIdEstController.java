package controller.estimate;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.dao.impl.OrderLineDAOImpl;
import model.domain.EstimateBoard;
import model.domain.OrderItem;
import model.service.EstimateService;

public class SelectByCusIdProdIdEstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerId = (String) request.getSession().getAttribute("userId");
		
		if (customerId == null || customerId.equals("")) {
			throw new NotFoundException("���ڰ� �����մϴ�.");
		}
		//�� ��Ʈ�ѷ����� �ϴ� �� : userId�� orderProdId ����Ʈ�� ����
		//�ۼ��� ������ ����id�� ����
		//�ΰ��� ���ؼ� ���� �ۼ����� ���� ����id�� setAttr�� ������
		List<OrderItem> itemList = new OrderLineDAOImpl().selectByCustomerId(customerId);
		if(!itemList.isEmpty()) {
			List<String> prodIdList = new ArrayList<String>(); //������ ��ǰ�� id ����Ʈ
			for(OrderItem item:itemList) {
				prodIdList.add(item.getProduct().getId());//��ǰ�� id ���ϱ�
			}
			
			//request.getSession().setAttribute("itemList", itemList);�ʿ��ϸ� ����
			List<EstimateBoard> estimateList = EstimateService.selectByCustomerId(customerId);//������ �ۼ��� ������ ����Ʈ
			//request.setAttribute("estimateList", estimateList); //�ʿ��ϸ� ����
			List<String> estProdIdList = new ArrayList<String>(); //������ ����� ��ǰ id ����Ʈ
			for(EstimateBoard estBoard:estimateList) {
				estProdIdList.add(estBoard.getProduct().getId());
			}
		
			for(int i=0 ; i<prodIdList.size() ;i++) {
				for(int j=0 ;j<estProdIdList.size() ;j++) {
					if(prodIdList.get(i).equals(estProdIdList.get(j))) {//�����򸮽�Ʈ�� ������ �̹� �ۼ���, ����Ʈ���� ����
						prodIdList.remove(i);
					}//end if
				}//end for j
			}//end for i
			//request.setAttribute("estPosList", prodIdList);//���� ������ �ۼ����� ���� ��ǰid ����Ʈ
			for(OrderItem item:itemList) {
				for(String prodId :prodIdList) {
					if(!item.getProduct().getId().equals(prodId)) {
						itemList.remove(item);
					}
				}
			}
			request.setAttribute("estPosList", itemList);//���� ������ �ۼ����� ���� ��ǰid ����Ʈ
		}
		ModelAndView mv=new ModelAndView();
		mv.setRedirect(false);
		mv.setViewName("community/evaluateForm.jsp");
		return mv;
	}

}
