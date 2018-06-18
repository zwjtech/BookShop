package com.bsw.servlet.shopcart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsw.shopcart.ShopCart;
import com.bsw.shopcart.ShopCartDAO;
import com.bsw.servlet.common.*;

/**
 * �����ʵ�����ﳵ������Ʒ
 * @author Student
 * @version 1.0.0
 */
public class ModifyShopCartItemControl extends AbstractServlet {

	/**
	 * �޲ι��캯��
	 */
	public ModifyShopCartItemControl() {
		super();
	}

	

	/**
	 * �̳и���Ĺ��캯����ʵ��ҵ���߼�
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// ȡ�ò���
		int id = Integer.parseInt(request.getParameter("id"));
		ShopCartDAO shopCartDAO = new ShopCartDAO();
		
		// ����
		ShopCart shopcart = shopCartDAO.queryByID(id);
		request.setAttribute("shopcart", shopcart);
		request.getRequestDispatcher("/com/bsw/cart/modifyShopCart.jsp").forward(request, response);
	}

}
