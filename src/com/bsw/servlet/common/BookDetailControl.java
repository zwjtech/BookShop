package com.bsw.servlet.common;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bsw.book.*;
import com.bsw.bookcategory.*;

/**
 * 继承 HttpServlet 类
 * 实现显示图书详细信息的功能
 * 
 * @author Student
 * @version 1.0.0
 */
public class BookDetailControl extends HttpServlet {

	/**
	 * 无参构造函数
	 */
	public BookDetailControl() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset = UTF-8");
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符集
		response.setContentType("text/html;charset = UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// 获取参数
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		int categoryID = Integer.parseInt(request.getParameter("categoryID"));
		
		// 分别查询书的信息和数的编号对应的名称
		BookCategoryDAO categoryDAO = new BookCategoryDAO();
		BookCategory category = categoryDAO.queryByID(categoryID);
		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.queryBook(bookID);
		
		// 设置参数
		request.setAttribute("book", book);
		request.setAttribute("categoryName", category.getName());
		
		// 实现页面跳转
		request.getRequestDispatcher("/com/bsw/book/showBookDetail.jsp").forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
