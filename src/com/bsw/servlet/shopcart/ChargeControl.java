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
 * �����ʵ�ֽ��ʹ��ܣ����ѽ�����Ϣд�����ݿ�
 * @author Student
 * @version 1.0.0
 */
public class ChargeControl extends AbstractServlet {

	/**
	 * �޲ι��캯��
	 */
	public ChargeControl() {
		super();
	}
	
	
	/**
	 * ʵ�ָ���ķ�����ʵ��ҵ���߼�
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ��session��ȡ��user����
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int userId = user.getId();
		ShopCartDAO shopCartDAO = new ShopCartDAO();
		TradeRecordDOA tdao = new TradeRecordDOA();
		
		// �����û�����ѯ���ﳵ
		ArrayList shopCartList = shopCartDAO.queryBook(userId);
		Iterator it = shopCartList.iterator();
		while(it.hasNext()){
			
			// �ӹ��ﳵ��ɾ��
			ShopCart shopCart = (ShopCart)it.next();
			int id= shopCart.getId();
			shopCartDAO.deleteItem(id);
			
			// �����׼�¼д�����ݿ�
			TradeRecord tradeRecord = new TradeRecord();
			tradeRecord.setUserId(userId);
			tradeRecord.setBookId(shopCart.getBookID());
			tradeRecord.setTradeNum(shopCart.getNum());
			tradeRecord.setStatus(1);
			tdao.insertTradeRecord(tradeRecord);
		}
		out.println("<center>");
		out.println("���Ѿ��ɹ������ˣ�<br>");
		out.println("<a href=\"/BookShop/servlet/LoginControl\">��������</a>");
		out.println("</center>");
		out.flush();
		out.close();
	}

}
