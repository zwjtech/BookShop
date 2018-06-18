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
 * �̳� AbstractServlet ��
 * ʵ��ͼ��Ŀ¼�Ĺ���
 * 
 * @author Student
 * @version 1.0.0
 */
public class BookCateManagerControl extends AbstractServlet {

	
	/**
	 * ���ݾ������������ͬ�ķ���
	 */
	public void execute(HttpServletRequest request, 
				HttpServletResponse response)
			throws ServletException, IOException {
		

		int index = Integer.parseInt(request.getParameter("index")); // ��ʾ������ĸ�����
		//System.out.println("servlet " +index);
			switch (index) {
			
				case 1:
					addBookCate(request,response); // ����ͼ�����
					break;
					
				case 2:
					modifyBookCate(request,response); // �޸�ͼ�����
					break;
					
				case 3:
					deleteBookCate(request,response); // ɾ��ͼ�����
					break;
					
				default:
				
				
			}
			
			//���� ��������ת
			BookCategoryDAO bookCate = new BookCategoryDAO();
			ArrayList al = bookCate.queryBookCategory();
			
			request.setAttribute("bookCategory", al);
			request.getRequestDispatcher("/com/bsw/manager/bookCateManage.jsp")
					.forward(request, response);
			
	}
	
	/**
	 * ����ͼ�����
	 *
	 */
	private void addBookCate(HttpServletRequest request, 
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		// �õ����������
		String categoryName = request.getParameter("category");
		//System.out.println(categoryName);
		BookCategoryDAO bookCate = new BookCategoryDAO();
		bookCate.addBookCategory(categoryName); // ���뵽���ݿ�
	}
	
	/**
	 * �޸�ͼ�����
	 *
	 */
	private void modifyBookCate(HttpServletRequest request, 
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		// �õ������ݺͲ���
		String categoryName = request.getParameter("category");
		//System.out.println(categoryName);
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		
		BookCategoryDAO bookCate = new BookCategoryDAO();
		bookCate.modifyBookCategory(categoryName, id); // ����������id�޸�֮
	}
	
	/**
	 * ɾ��ͼ�����
	 *
	 */
	private void deleteBookCate(HttpServletRequest request,
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		// �õ�id��
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		
		BookCategoryDAO bookCate = new BookCategoryDAO();
		bookCate.deleteBookCategory(id); //  ����id�������ݿ���ɾ��֮
		
	}
	

}
