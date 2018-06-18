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
 * 这个类实现向购物车加入商品
 * @author Student
 * @version 1.0.0
 */
public class DeleteShopCartItemControl extends AbstractServlet {

	/**
	 * 无参构造函数
	 */
	public DeleteShopCartItemControl() {
		super();
	}
	

	/**
	 * 实现业务逻辑，删除购物车中的数据
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ShopCartDAO shopCartDAO = new ShopCartDAO();
		BookDAO bookDAO = new BookDAO();
		
		// 取得参数
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int userId = user.getId();
		int num = Integer.parseInt(request.getParameter("num"));
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		// 更新库存数量
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
