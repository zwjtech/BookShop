package com.bsw.servlet.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsw.book.Book;
import com.bsw.book.BookDAO;
import com.bsw.bookcategory.BookCategory;
import com.bsw.bookcategory.BookCategoryDAO;

/**
 * 处理后台管理
 * @author Student
 * @version 1.0.0
 */
public class BookInfoManageControl extends AbstractServlet {

	/**
	 * 无参构造函数调用父类构造函数
	 */
	public BookInfoManageControl() {
		super();
	}

	/**
	 * 实现父类的抽象方法，封装业务逻辑
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// 判断请求的类型
		int action = Integer.parseInt(request.getParameter("action"));
		switch(action){
			case 1: addNewBook(request,response); break; // 加入新书
			case 2: modifyBookInfo(request,response); break; // 修改图书的信息
			case 3: deleteBook(request,response); break; // 删除图书
		}
	}
   
	/**
	 * 实现添加图书页面跳转功能
	 * @param request HttpServlet的对象，封装客户的request请求
	 * @param response HttpServlet的对象，封装对客户的response响应
	 * @throws ServletException 任何ServletException发生时
	 * @throws IOException IO异常发生
	 */
	public void addNewBook(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// 查询图书所在的类别名称
		BookCategoryDAO categoryDAO = new BookCategoryDAO();
		ArrayList categories = categoryDAO.queryBookCategory();
		// 将所有的图书类别
		HashMap cates = new HashMap();
		Integer id = 0;
		String name = "";
		for(int i = 0; i < categories.size(); i++){
			BookCategory categoryItem = (BookCategory)categories.get(i);
			
			// 得到key值和value值，并插入到HashMap中
			id = categoryItem.getId();
			name = categoryItem.getName();
			cates.put(id, name);
		}
		request.setAttribute("cates",cates);
		request.getRequestDispatcher("/com/bsw/manager/addBook.jsp").forward(request, response);
	}
	
	/**
	 * 实现修改图书的功能
	 * @param request HttpServlet的对象，封装客户的request请求
	 * @param response HttpServlet的对象，封装对客户的response响应
	 * @throws ServletException 任何ServletException发生时
	 * @throws IOException IO异常发生
	 */
	public void modifyBookInfo(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		// 获得图书的id号
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		
		// 查询该图书
		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.queryBook(bookID);
		
		// 查询图书所在的类别名称
		
		BookCategoryDAO categoryDAO = new BookCategoryDAO();
		ArrayList categories = categoryDAO.queryBookCategory();
		
		// 将所有的图书类别
		HashMap cates = new HashMap();
		Integer id = 0;
		String name = "";
		for(int i = 0; i < categories.size(); i++){
			BookCategory categoryItem = (BookCategory)categories.get(i);
			
			// 得到key值和value值，并插入到HashMap中
			id = categoryItem.getId();
			name = categoryItem.getName();
			cates.put(id, name);
		}
		
		//向下一页面传参数
		request.setAttribute("book",book); 
		request.setAttribute("cates",cates);
		request.getRequestDispatcher("/com/bsw/manager/modifyBook.jsp").forward(request, response);
	}
	
	public void deleteBook (HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		// 获得参数bookID
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		
		// 删除并显示
		BookDAO bookDAO = new BookDAO();
		bookDAO.deleteBook(bookID);
		ArrayList books = bookDAO.queryBook();
		request.setAttribute("books", books);
		request.getRequestDispatcher("/com/bsw/manager/bookInfoManage.jsp").forward(request, response);
	}
	
}

























