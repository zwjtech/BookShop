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
 * 处理后台管理
 * @author Student
 * @version 1.0.0
 */
public class ManagerControl extends AbstractServlet {

	/**
	 * 根据具体参数，给不同的服务
	 */
	public void execute(HttpServletRequest request, 
				HttpServletResponse response)
			throws ServletException, IOException {
		
		int index = Integer.parseInt(request.getParameter("index")); // 表示点击的哪个链接
		
		switch (index) {
		
			case 1:
				managerindex(request,response); // 进入后台管理首页
				break;
				
			case 2:
				managerBookCatergory(request,response); // 图书类别管理
				break;
				
			case 3:
				managerBookInfo(request,response); // 图书信息管理
				break;
				
			case 4:
				managerBookTradeInfo(request,response); // 图书销售信息
				
				break;
				
			case 5:
				managerExit(request,response); // 退出管理系统
				break;
				
			default:
			
			
		}
	}
	
	/**
	 * 后台管理首页
	 *
	 */
	private void managerindex(HttpServletRequest request, 
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		response.sendRedirect("/BookShop/com/bsw/manager/blockManage.jsp"); // 跳转
	}
	
	/**
	 * 图书类别管理
	 *
	 */
	private void managerBookCatergory(HttpServletRequest request, 
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		BookCategoryDAO bookCate = new BookCategoryDAO();
		ArrayList al = bookCate.queryBookCategory(); // 从数据库中查所有类别
		
		request.setAttribute("bookCategory", al); // 放入request
		request.getRequestDispatcher("/com/bsw/manager/bookCateManage.jsp")
				.forward(request, response);
		
	}
	
	/**
	 * 图书信息管理
	 *
	 */
	private void managerBookInfo(HttpServletRequest request,
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		BookDAO bookDoa = new BookDAO();
		ArrayList al = bookDoa.queryBook(); // 从数据库中查所有图书信息
		
		request.setAttribute("books", al); // 放入request
		request.getRequestDispatcher("/com/bsw/manager/bookInfoManage.jsp")
				.forward(request, response);
		
	}
	
	/**
	 * 图书销售信息
	 */
	private void managerBookTradeInfo(HttpServletRequest request,
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		TradeRecordDOA tr=new TradeRecordDOA();
		HashMap hashMap=new HashMap();
		ArrayList recordArrayList=tr.queryOrders();
		Iterator iter=recordArrayList.iterator();
		
		// 计算每个交易记录的总价
		while(iter.hasNext()) {
			
			BookDAO book1=new BookDAO(); 
			
			TradeRecord record=(TradeRecord)iter.next();
			
			Book book=book1.queryBook(record.getBookId());	// 根据 bookId 查出 book 对象
			double price=record.getTradeNum()*book.getPrice(); // 根据 交易总数和 book 的当单加算出 交易总价
			
			hashMap.put(record,price); // 放入 hanshMap
			
		}
		
		request.setAttribute("hashMap",hashMap);
		request.getRequestDispatcher("/com/bsw/manager/bookSellInfo.jsp").forward(request, response);
	}
	
	/**
	 * 退出管理系统
	 */
	private void managerExit(HttpServletRequest request,
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		 request.getSession().removeAttribute("user"); //  清除session 中的 user 对象
		 request.getRequestDispatcher("/com/bsw/manager/exitManagerSystem.jsp").forward(request, response);
	    
	    
	}
}
