package com.bsw.servlet.shopcart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bsw.book.Book;
import com.bsw.servlet.common.*;
import com.bsw.book.BookDAO;
import com.bsw.shopcart.ShopCart;
import com.bsw.shopcart.ShopCartDAO;
import com.bsw.user.User;

/**
 * �����ʵ�����ﳵ������Ʒ
 * @author Student
 * @version 1.0.0
 */
public class AddToShopCartControl extends AbstractServlet {

	/**
	 * �޲ι��캯��
	 */
	public AddToShopCartControl() {
		super();
	}
	
	/**
	 * ʵ�ָ���Ĺ��캯����ʵ��ҵ���߼�
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ַ��� 
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset = UTF-8");
		
		//��session��ȡ���û���
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		//����û�id��book��� 
		int userID = user.getId();
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		//update�������
		BookDAO bookDAO = new BookDAO();
		bookDAO.updateCurrentNum(num, bookID);
		num = -num;
		
		//��ѯ��ı��
		Book book = bookDAO.queryBook(bookID);
		ShopCartDAO shopCartDAO = new ShopCartDAO();
		ShopCart shopcart = new ShopCart();
		
		//���ù��ﳵ�������
		shopcart.setBookName(book.getName());
		shopcart.setNum(num);
		shopcart.setPrice(book.getPrice());
		shopcart.setUserId(userID);
		shopcart.setBookID(book.getId());
		
		//��������뵽���ݿ���
		shopCartDAO.insertItem(shopcart);
		response.sendRedirect("/BookShop/com/bsw/cart/addShopCartSuccess.jsp");
	}

}
