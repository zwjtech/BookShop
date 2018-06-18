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
 * 这个类实现显示购物车里的数据
 * @author Student
 * @version 1.0.0
 */
public class ShopCartControl extends AbstractServlet {

	/**
	 * 无参构造函数
	 *
	 */
	public ShopCartControl() {
		super();
	}
	
	/**
	 * 继承父类的方法，实现业务逻辑
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// 从session中取得用户名
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int id = user.getId();
		ShopCartDAO shopCartDAO = new ShopCartDAO();
		
		// 查询书的记录
		ArrayList list = shopCartDAO.queryBook(id);
		request.setAttribute("cartList", list);
		
		// 跳转页面
		request.getRequestDispatcher("/com/bsw/cart/viewCart.jsp").forward(request, response);
	}

}
