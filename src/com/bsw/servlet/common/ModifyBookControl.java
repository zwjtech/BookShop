package com.bsw.servlet.common;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsw.book.Book;
import com.bsw.book.BookDAO;

/**
 * �̳� AbstractServlet ��
 * ʵ���޸�ͼ��Ĺ���
 * 
 * @author Student
 * @version 1.0.0
 */
public class ModifyBookControl extends AbstractServlet {
		/**
		 * ���ݾ������������ͬ�ķ���
		 */
		public void execute(HttpServletRequest request, 
					HttpServletResponse response)
				throws ServletException, IOException{
			// ���ñ����ʽ
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			Book book=new Book();
			BookDAO dao=new BookDAO(); 
			
			// ��ò���
			book.setId(Integer.parseInt(request.getParameter("bookID")));
			book.setName(request.getParameter("name"));
			book.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			book.setPrice(Double.parseDouble(request.getParameter("price")));
			book.setAuthor(request.getParameter("author"));
			book.setBookman(request.getParameter("bookman"));
			book.setTotal(Integer.parseInt(request.getParameter("total")));
			book.setCurrentNum(Integer.parseInt(request.getParameter("nowtotal")));
			book.setIntroduction(request.getParameter("introduction"));
			book.setStatus(1);
			String addTime = request.getParameter("addTime");
			DateFormat d = DateFormat.getDateInstance();
			try {
				Date date = new Date(d.parse(addTime).getTime());
				book.setAddTime(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		   // ��������
            if(dao.updateBook(book)){
            	request.getRequestDispatcher("/servlet/ManagerControl?index=3").forward(request, response);
            }else{
            	out.println("upDate failed!!");
            }
		}
}
