package com.bsw.servlet.common;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsw.book.Book;
import com.bsw.book.BookDAO;

/**
 * �̳� AbstractServlet ��
 * ʵ�������ͼ��Ĺ���
 * 
 * @author Student
 * @version 1.0.0
 */
public class AddNewBookControl extends AbstractServlet {
	
	/**
	 * �޲ι��캯�����ø��๹�캯��
	 */
	public AddNewBookControl() {
		super();
	}

	/**
	 * ʵ�ָ��෽����ʵ��ҵ���߼�
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Book book = new Book();
		BookDAO bookDAO = new BookDAO();
		
		// ��ò���
		String name = request.getParameter("name");
		book.setName(name);
		book.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		book.setAuthor(request.getParameter("author"));
		book.setBookman(request.getParameter("bookman"));
		book.setTotal(Integer.parseInt(request.getParameter("total")));
		book.setCurrentNum(Integer.parseInt(request.getParameter("nowtotal")));
		book.setStatus(1);
		book.setIntroduction(request.getParameter("introduction"));
		DateFormat d = DateFormat.getDateInstance();
		
		// ��ѯ���ݿ⣬���ṹ��ʾ
		ArrayList books = null;
		try{
			Date date = new Date(d.parse(request.getParameter("addTime")).getTime());
			book.setAddTime(date);
			bookDAO.insertBook(book);
			books = bookDAO.queryBook();
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		// ���ò�����ʵ��ҳ����ת
		request.setAttribute("books", books);
		request.getRequestDispatcher("/com/bsw/manager/bookInfoManage.jsp").forward(request, response);
	}
}
