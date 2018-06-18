package com.bsw.servlet.shopcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bsw.book.BookDAO;
import com.bsw.shopcart.ShopCart;
import com.bsw.shopcart.ShopCartDAO;
import com.bsw.user.User;
import com.bsw.servlet.common.*;

/**
 * �����ʵ�����ﳵ������Ʒ
 * @author Student
 * @version 1.0.0
 */
public class DeleteShopCartItemControl extends AbstractServlet {

	/**
	 * �޲ι��캯��
	 */
	public DeleteShopCartItemControl() {
		super();
	}
	

	/**
	 * ʵ��ҵ���߼���ɾ�����ﳵ�е�����
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ShopCartDAO shopCartDAO = new ShopCartDAO();
		BookDAO bookDAO = new BookDAO();
		
		// ȡ�ò���
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int userId = user.getId();
		int num = Integer.parseInt(request.getParameter("num"));
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		// ���¿������
		bookDAO.updateCurrentNum(num, bookId);
		if(shopCartDAO.deleteItem(id)){
			ArrayList cartList = shopCartDAO.queryBook(userId);
			request.setAttribute("cartList", cartList);
			request.getRequestDispatcher("/com/bsw/cart/viewCart.jsp").forward(request, response);
		}else{
			response.sendRedirect("/com/bsw/error/error.jsp");
		}
	}
}
