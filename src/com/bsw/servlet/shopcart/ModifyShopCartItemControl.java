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
 * 这个类实现向购物车加入商品
 * @author Student
 * @version 1.0.0
 */
public class ModifyShopCartItemControl extends AbstractServlet {

	/**
	 * 无参构造函数
	 */
	public ModifyShopCartItemControl() {
		super();
	}

	

	/**
	 * 继承父类的构造函数，实现业务逻辑
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 取得参数
		int id = Integer.parseInt(request.getParameter("id"));
		ShopCartDAO shopCartDAO = new ShopCartDAO();
		
		// 查找
		ShopCart shopcart = shopCartDAO.queryByID(id);
		request.setAttribute("shopcart", shopcart);
		request.getRequestDispatcher("/com/bsw/cart/modifyShopCart.jsp").forward(request, response);
	}

}
