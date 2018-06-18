package com.bsw.servlet.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsw.book.BookDAO;
import com.bsw.bookcategory.BookCategoryDAO;

/**
 * 继承 HttpServlet 类
 * 实现显示该图书类别所有图书的功能
 * 
 * @author Student
 * @version 1.0.0
 */
public class CategoryDetailControl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CategoryDetailControl() {
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
		
		// 获取参数
		String cid = request.getParameter("categoryID");
		int categoryID = Integer.parseInt(cid);
		
		// 查询该类别的所有图书
		BookDAO bookDAO = new BookDAO();
		ArrayList books = bookDAO.queryByCategory(categoryID);
		request.setAttribute("newBooks",books);
		
		// 查询所有新书的名称
		ArrayList newBooks = new ArrayList();
		newBooks = bookDAO.queryNewBooks();
		request.setAttribute("newBooksName",newBooks);
		
		// 查询所有的目录
		BookCategoryDAO categoryDAO = new BookCategoryDAO();
		ArrayList categories = categoryDAO.queryBookCategory();
		request.setAttribute("categories", categories);
		
		// 实现页面跳转
		request.getRequestDispatcher("/com/bsw/welcome/welcome.jsp").forward(request, response);
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
