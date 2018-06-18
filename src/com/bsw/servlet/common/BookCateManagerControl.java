package com.bsw.servlet.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsw.book.Book;
import com.bsw.book.BookDAO;
import com.bsw.bookcategory.BookCategoryDAO;
import com.bsw.traderecord.TradeRecord;
import com.bsw.traderecord.TradeRecordDOA;
import java.util.*;

/**
 * 继承 AbstractServlet 类
 * 实现图书目录的功能
 * 
 * @author Student
 * @version 1.0.0
 */
public class BookCateManagerControl extends AbstractServlet {

	
	/**
	 * 根据具体参数，给不同的服务
	 */
	public void execute(HttpServletRequest request, 
				HttpServletResponse response)
			throws ServletException, IOException {
		

		int index = Integer.parseInt(request.getParameter("index")); // 表示点击的哪个链接
		//System.out.println("servlet " +index);
			switch (index) {
			
				case 1:
					addBookCate(request,response); // 增加图书类别
					break;
					
				case 2:
					modifyBookCate(request,response); // 修改图书类别
					break;
					
				case 3:
					deleteBookCate(request,response); // 删除图书类别
					break;
					
				default:
				
				
			}
			
			//更新 容器并跳转
			BookCategoryDAO bookCate = new BookCategoryDAO();
			ArrayList al = bookCate.queryBookCategory();
			
			request.setAttribute("bookCategory", al);
			request.getRequestDispatcher("/com/bsw/manager/bookCateManage.jsp")
					.forward(request, response);
			
	}
	
	/**
	 * 增加图书类别
	 *
	 */
	private void addBookCate(HttpServletRequest request, 
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		// 得到书类别名称
		String categoryName = request.getParameter("category");
		//System.out.println(categoryName);
		BookCategoryDAO bookCate = new BookCategoryDAO();
		bookCate.addBookCategory(categoryName); // 加入到数据库
	}
	
	/**
	 * 修改图书类别
	 *
	 */
	private void modifyBookCate(HttpServletRequest request, 
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		// 得到表单内容和参数
		String categoryName = request.getParameter("category");
		//System.out.println(categoryName);
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		
		BookCategoryDAO bookCate = new BookCategoryDAO();
		bookCate.modifyBookCategory(categoryName, id); // 根据类名和id修改之
	}
	
	/**
	 * 删除图书类别
	 *
	 */
	private void deleteBookCate(HttpServletRequest request,
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		// 得到id号
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		
		BookCategoryDAO bookCate = new BookCategoryDAO();
		bookCate.deleteBookCategory(id); //  根据id号在数据库中删除之
		
	}
	

}
