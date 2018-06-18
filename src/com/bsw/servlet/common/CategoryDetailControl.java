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
 * �̳� HttpServlet ��
 * ʵ����ʾ��ͼ���������ͼ��Ĺ���
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
		
		// �����ַ���
		response.setContentType("text/html;charset = UTF-8");
		
		// ��ȡ����
		String cid = request.getParameter("categoryID");
		int categoryID = Integer.parseInt(cid);
		
		// ��ѯ����������ͼ��
		BookDAO bookDAO = new BookDAO();
		ArrayList books = bookDAO.queryByCategory(categoryID);
		request.setAttribute("newBooks",books);
		
		// ��ѯ�������������
		ArrayList newBooks = new ArrayList();
		newBooks = bookDAO.queryNewBooks();
		request.setAttribute("newBooksName",newBooks);
		
		// ��ѯ���е�Ŀ¼
		BookCategoryDAO categoryDAO = new BookCategoryDAO();
		ArrayList categories = categoryDAO.queryBookCategory();
		request.setAttribute("categories", categories);
		
		// ʵ��ҳ����ת
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