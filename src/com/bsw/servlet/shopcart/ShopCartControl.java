package com.bsw.servlet.shopcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bsw.shopcart.ShopCartDAO;
import com.bsw.user.User;
import com.bsw.servlet.common.*;

/**
 * �����ʵ����ʾ���ﳵ�������
 * @author Student
 * @version 1.0.0
 */
public class ShopCartControl extends AbstractServlet {

	/**
	 * �޲ι��캯��
	 *
	 */
	public ShopCartControl() {
		super();
	}
	
	/**
	 * �̳и���ķ�����ʵ��ҵ���߼�
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// ��session��ȡ���û���
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int id = user.getId();
		ShopCartDAO shopCartDAO = new ShopCartDAO();
		
		// ��ѯ��ļ�¼
		ArrayList list = shopCartDAO.queryBook(id);
		request.setAttribute("cartList", list);
		
		// ��תҳ��
		request.getRequestDispatcher("/com/bsw/cart/viewCart.jsp").forward(request, response);
	}

}
