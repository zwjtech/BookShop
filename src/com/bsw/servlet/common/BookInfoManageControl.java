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
 * �����̨����
 * @author Student
 * @version 1.0.0
 */
public class BookInfoManageControl extends AbstractServlet {

	/**
	 * �޲ι��캯�����ø��๹�캯��
	 */
	public BookInfoManageControl() {
		super();
	}

	/**
	 * ʵ�ָ���ĳ��󷽷�����װҵ���߼�
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// �ж����������
		int action = Integer.parseInt(request.getParameter("action"));
		switch(action){
			case 1: addNewBook(request,response); break; // ��������
			case 2: modifyBookInfo(request,response); break; // �޸�ͼ�����Ϣ
			case 3: deleteBook(request,response); break; // ɾ��ͼ��
		}
	}
   
	/**
	 * ʵ�����ͼ��ҳ����ת����
	 * @param request HttpServlet�Ķ��󣬷�װ�ͻ���request����
	 * @param response HttpServlet�Ķ��󣬷�װ�Կͻ���response��Ӧ
	 * @throws ServletException �κ�ServletException����ʱ
	 * @throws IOException IO�쳣����
	 */
	public void addNewBook(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// ��ѯͼ�����ڵ��������
		BookCategoryDAO categoryDAO = new BookCategoryDAO();
		ArrayList categories = categoryDAO.queryBookCategory();
		// �����е�ͼ�����
		HashMap cates = new HashMap();
		Integer id = 0;
		String name = "";
		for(int i = 0; i < categories.size(); i++){
			BookCategory categoryItem = (BookCategory)categories.get(i);
			
			// �õ�keyֵ��valueֵ�������뵽HashMap��
			id = categoryItem.getId();
			name = categoryItem.getName();
			cates.put(id, name);
		}
		request.setAttribute("cates",cates);
		request.getRequestDispatcher("/com/bsw/manager/addBook.jsp").forward(request, response);
	}
	
	/**
	 * ʵ���޸�ͼ��Ĺ���
	 * @param request HttpServlet�Ķ��󣬷�װ�ͻ���request����
	 * @param response HttpServlet�Ķ��󣬷�װ�Կͻ���response��Ӧ
	 * @throws ServletException �κ�ServletException����ʱ
	 * @throws IOException IO�쳣����
	 */
	public void modifyBookInfo(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		// ���ͼ���id��
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		
		// ��ѯ��ͼ��
		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.queryBook(bookID);
		
		// ��ѯͼ�����ڵ��������
		
		BookCategoryDAO categoryDAO = new BookCategoryDAO();
		ArrayList categories = categoryDAO.queryBookCategory();
		
		// �����е�ͼ�����
		HashMap cates = new HashMap();
		Integer id = 0;
		String name = "";
		for(int i = 0; i < categories.size(); i++){
			BookCategory categoryItem = (BookCategory)categories.get(i);
			
			// �õ�keyֵ��valueֵ�������뵽HashMap��
			id = categoryItem.getId();
			name = categoryItem.getName();
			cates.put(id, name);
		}
		
		//����һҳ�洫����
		request.setAttribute("book",book); 
		request.setAttribute("cates",cates);
		request.getRequestDispatcher("/com/bsw/manager/modifyBook.jsp").forward(request, response);
	}
	
	public void deleteBook (HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		// ��ò���bookID
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		
		// ɾ������ʾ
		BookDAO bookDAO = new BookDAO();
		bookDAO.deleteBook(bookID);
		ArrayList books = bookDAO.queryBook();
		request.setAttribute("books", books);
		request.getRequestDispatcher("/com/bsw/manager/bookInfoManage.jsp").forward(request, response);
	}
	
}

























