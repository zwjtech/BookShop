package com.bsw.servlet.shopcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bsw.shopcart.ShopCart;
import com.bsw.shopcart.ShopCartDAO;
import com.bsw.traderecord.TradeRecord;
import com.bsw.traderecord.TradeRecordDOA;
import com.bsw.user.User;
import com.bsw.servlet.common.*;

/**
 * 这个类实现结帐功能，并把交易信息写入数据库
 * @author Student
 * @version 1.0.0
 */
public class ChargeControl extends AbstractServlet {

	/**
	 * 无参构造函数
	 */
	public ChargeControl() {
		super();
	}
	
	
	/**
	 * 实现父类的方法，实现业务逻辑
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 从session中取得user对象
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int userId = user.getId();
		ShopCartDAO shopCartDAO = new ShopCartDAO();
		TradeRecordDOA tdao = new TradeRecordDOA();
		
		// 根据用户名查询购物车
		ArrayList shopCartList = shopCartDAO.queryBook(userId);
		Iterator it = shopCartList.iterator();
		while(it.hasNext()){
			
			// 从购物车中删除
			ShopCart shopCart = (ShopCart)it.next();
			int id= shopCart.getId();
			shopCartDAO.deleteItem(id);
			
			// 将交易记录写入数据库
			TradeRecord tradeRecord = new TradeRecord();
			tradeRecord.setUserId(userId);
			tradeRecord.setBookId(shopCart.getBookID());
			tradeRecord.setTradeNum(shopCart.getNum());
			tradeRecord.setStatus(1);
			tdao.insertTradeRecord(tradeRecord);
		}
		out.println("<center>");
		out.println("您已经成功结帐了！<br>");
		out.println("<a href=\"/BookShop/servlet/LoginControl\">继续购物</a>");
		out.println("</center>");
		out.flush();
		out.close();
	}

}
