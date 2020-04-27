//package listener;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.ResourceBundle;
//import java.util.Set;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//import controller.Controller;
//
///**
// * ����� ��û�� �ش��ϴ� key�� ���� ��ü�� �̸� �����ؼ� 
// * Map�� ������ �� ��� �������� ����� �� �ֵ��� application scope��
// * Map�� �����Ѵ�.
// */
//@WebListener
//public class HandlerMappingListener implements ServletContextListener {
//
//    public void contextDestroyed(ServletContextEvent e)  { }
//
//    public void contextInitialized(ServletContextEvent e)  { 
//    	Map<String, Controller> map = new HashMap<String, Controller>();
//    	ServletContext application = e.getServletContext();
//
//    	//key�� �ش��ϴ� className�� �����ϴ� properties�����ε�
//    	String fileName = application.getInitParameter("fileName");
//    	ResourceBundle rb = ResourceBundle.getBundle(fileName);	//ResourceBundle�� Ȯ���ڸ� ���� �ʴ´�
//    	Set<String> keys = rb.keySet();
//    	try {
//	    	for(String key : keys) {
//	    		String value = rb.getString(key);
//	    		//System.out.println(key + " = " + value);
//	    		//String value�� ��ü��(Controller) ���� Map�� �����Ѵ�.
//	    		Controller controller = (Controller)Class.forName(value).newInstance();
//	    		System.out.println(key + " = " + controller);	//controller�� �ּҰ��� ���
//	    		map.put(key, controller);
//	    	}
//    	}catch (Exception ex) {
//    		ex.printStackTrace();
//    	}
//    	
//    	//application������ �����Ѵ�.
//    	application.setAttribute("map", map);
//    }
//	
//}
