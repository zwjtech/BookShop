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
 * 这个类实现向购物车加入商品
 * @author Student
 * @version 1.0.0
 */
public class AddToShopCartControl extends AbstractServlet {

	/**
	 * 无参构造函数
	 */
	public AddToShopCartControl() {
		super();
	}
	
	/**
	 * 实现父类的构造函数，实现业务逻辑
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集 
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset = UTF-8");
		
		//从session中取得用户名
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		//获得用户id和book编号 
		int userID = user.getId();
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		int num = Integer.parseInt(request.getParameter("num"));
		
		//update书的数量
		BookDAO bookDAO = new BookDAO();
		bookDAO.updateCurrentNum(num, bookID);
		num = -num;
		
		//查询书的编号
		Book book = bookDAO.queryBook(bookID);
		ShopCartDAO shopCartDAO = new ShopCartDAO();
		ShopCart shopcart = new ShopCart();
		
		//设置购物车项的属性
		shopcart.setBookName(book.getName());
		shopcart.setNum(num);
		shopcart.setPrice(book.getPrice());
		shopcart.setUserId(userID);
		shopcart.setBookID(book.getId());
		
		//将改项插入到数据库中
		shopCartDAO.insertItem(shopcart);
		response.sendRedirect("/BookShop/com/bsw/cart/addShopCartSuccess.jsp");
	}

}
