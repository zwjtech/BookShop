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
 * 继承 AbstractServlet 类
 * 实现添加新图书的功能
 * 
 * @author Student
 * @version 1.0.0
 */
public class AddNewBookControl extends AbstractServlet {
	
	/**
	 * 无参构造函数调用父类构造函数
	 */
	public AddNewBookControl() {
		super();
	}

	/**
	 * 实现父类方法，实现业务逻辑
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Book book = new Book();
		BookDAO bookDAO = new BookDAO();
		
		// 获得参数
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
		
		// 查询数据库，将结构显示
		ArrayList books = null;
		try{
			Date date = new Date(d.parse(request.getParameter("addTime")).getTime());
			book.setAddTime(date);
			bookDAO.insertBook(book);
			books = bookDAO.queryBook();
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		// 设置参数并实现页面跳转
		request.setAttribute("books", books);
		request.getRequestDispatcher("/com/bsw/manager/bookInfoManage.jsp").forward(request, response);
	}
}
