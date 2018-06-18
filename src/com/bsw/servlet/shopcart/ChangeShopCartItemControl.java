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
 * 这个类实现修改购物车里的数据的方法
 * @author Student
 * @version 1.0.0
 */
public class ChangeShopCartItemControl extends AbstractServlet {

	/**
	 * 无参构造函数
	 */
	public ChangeShopCartItemControl() {
		super();
	}
	
	/**
	 * 继承父类的方法，实现业务逻辑
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ShopCartDAO shopCartDAO = new ShopCartDAO();
		BookDAO bookDAO = new BookDAO();
		
		// 获得参数
		int id = Integer.parseInt(request.getParameter("id"));
		int num = Integer.parseInt(request.getParameter("num"));
		int beforeNum = Integer.parseInt(request.getParameter("beforeNum"));
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		
		if(bookDAO.updateCurrentNum(beforeNum-num, bookId)){
			System.out.println("sussss");
		}
		
		// 根据用户查询购物车
		HttpSession session = request.getSession(); 
		User user =(User)session.getAttribute("user");
		if(shopCartDAO.modifyNum(id, num)){
			ArrayList shopCartList = shopCartDAO.queryBook(user.getId());
			request.setAttribute("cartList", shopCartList);
			// 查询数据库，用以显示
			request.getRequestDispatcher("/com/bsw/cart/viewCart.jsp").forward(request, response);
		}else{
			response.sendRedirect("/com/bsw/error/error.jsp");
		}
	}
}
