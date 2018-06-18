package com.bsw.servlet.shopcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bsw.servlet.common.*;
import com.bsw.book.BookDAO;
import com.bsw.shopcart.ShopCartDAO;
import com.bsw.user.User;

/**
 * �����ʵ���޸Ĺ��ﳵ������ݵķ���
 * @author Student
 * @version 1.0.0
 */
public class ChangeShopCartItemControl extends AbstractServlet {

	/**
	 * �޲ι��캯��
	 */
	public ChangeShopCartItemControl() {
		super();
	}
	
	/**
	 * �̳и���ķ�����ʵ��ҵ���߼�
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ShopCartDAO shopCartDAO = new ShopCartDAO();
		BookDAO bookDAO = new BookDAO();
		
		// ��ò���
		int id = Integer.parseInt(request.getParameter("id"));
		int num = Integer.parseInt(request.getParameter("num"));
		int beforeNum = Integer.parseInt(request.getParameter("beforeNum"));
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		
		if(bookDAO.updateCurrentNum(beforeNum-num, bookId)){
			System.out.println("sussss");
		}
		
		// �����û���ѯ���ﳵ
		HttpSession session = request.getSession(); 
		User user =(User)session.getAttribute("user");
		if(shopCartDAO.modifyNum(id, num)){
			ArrayList shopCartList = shopCartDAO.queryBook(user.getId());
			request.setAttribute("cartList", shopCartList);
			// ��ѯ���ݿ⣬������ʾ
			request.getRequestDispatcher("/com/bsw/cart/viewCart.jsp").forward(request, response);
		}else{
			response.sendRedirect("/com/bsw/error/error.jsp");
		}
	}
}
