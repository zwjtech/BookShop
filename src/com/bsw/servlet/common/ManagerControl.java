package com.bsw.servlet.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*; 
import com.bsw.bookcategory.*;
import com.bsw.traderecord.*;
import com.bsw.book.*;

/**
 * �����̨����
 * @author Student
 * @version 1.0.0
 */
public class ManagerControl extends AbstractServlet {

	/**
	 * ���ݾ������������ͬ�ķ���
	 */
	public void execute(HttpServletRequest request, 
				HttpServletResponse response)
			throws ServletException, IOException {
		
		int index = Integer.parseInt(request.getParameter("index")); // ��ʾ������ĸ�����
		
		switch (index) {
		
			case 1:
				managerindex(request,response); // �����̨������ҳ
				break;
				
			case 2:
				managerBookCatergory(request,response); // ͼ��������
				break;
				
			case 3:
				managerBookInfo(request,response); // ͼ����Ϣ����
				break;
				
			case 4:
				managerBookTradeInfo(request,response); // ͼ��������Ϣ
				
				break;
				
			case 5:
				managerExit(request,response); // �˳�����ϵͳ
				break;
				
			default:
			
			
		}
	}
	
	/**
	 * ��̨������ҳ
	 *
	 */
	private void managerindex(HttpServletRequest request, 
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		response.sendRedirect("/BookShop/com/bsw/manager/blockManage.jsp"); // ��ת
	}
	
	/**
	 * ͼ��������
	 *
	 */
	private void managerBookCatergory(HttpServletRequest request, 
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		BookCategoryDAO bookCate = new BookCategoryDAO();
		ArrayList al = bookCate.queryBookCategory(); // �����ݿ��в��������
		
		request.setAttribute("bookCategory", al); // ����request
		request.getRequestDispatcher("/com/bsw/manager/bookCateManage.jsp")
				.forward(request, response);
		
	}
	
	/**
	 * ͼ����Ϣ����
	 *
	 */
	private void managerBookInfo(HttpServletRequest request,
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		BookDAO bookDoa = new BookDAO();
		ArrayList al = bookDoa.queryBook(); // �����ݿ��в�����ͼ����Ϣ
		
		request.setAttribute("books", al); // ����request
		request.getRequestDispatcher("/com/bsw/manager/bookInfoManage.jsp")
				.forward(request, response);
		
	}
	
	/**
	 * ͼ��������Ϣ
	 */
	private void managerBookTradeInfo(HttpServletRequest request,
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		TradeRecordDOA tr=new TradeRecordDOA();
		HashMap hashMap=new HashMap();
		ArrayList recordArrayList=tr.queryOrders();
		Iterator iter=recordArrayList.iterator();
		
		// ����ÿ�����׼�¼���ܼ�
		while(iter.hasNext()) {
			
			BookDAO book1=new BookDAO(); 
			
			TradeRecord record=(TradeRecord)iter.next();
			
			Book book=book1.queryBook(record.getBookId());	// ���� bookId ��� book ����
			double price=record.getTradeNum()*book.getPrice(); // ���� ���������� book �ĵ�������� �����ܼ�
			
			hashMap.put(record,price); // ���� hanshMap
			
		}
		
		request.setAttribute("hashMap",hashMap);
		request.getRequestDispatcher("/com/bsw/manager/bookSellInfo.jsp").forward(request, response);
	}
	
	/**
	 * �˳�����ϵͳ
	 */
	private void managerExit(HttpServletRequest request,
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		 request.getSession().removeAttribute("user"); //  ���session �е� user ����
		 request.getRequestDispatcher("/com/bsw/manager/exitManagerSystem.jsp").forward(request, response);
	    
	    
	}
}
