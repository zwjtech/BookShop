package com.bsw.servlet.common;

import java.io.IOException;
import java.io.PrintWriter;
import com.bsw.user.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bsw.book.*;

/**
 * 处理后台管理
 * @author zwj
 * @version 1.0.0
 */
public class LoginControl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginControl() { 
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		UserDAO ud = new UserDAO();
		
		//设置标志位
		boolean isIn = false;
		boolean isManager =false;
		HttpSession session = request.getSession();
		
		// 获取参数
		User user = (User)session.getAttribute("user");
		String userName = request.getParameter("userName");
		//System.out.println("userName="+userName);//test,中文字符输出是乱码
		
		String password = request.getParameter("pwd");
		//String userName =new String(request.getParameter("userName").getBytes("ISO-8859-1"),"utf-8");
		
		System.out.println("userName="+userName);//test,中文字符输出是乱码
		
		// 判断用户是登陆，还是从其他页面跳转到该页面的
		if(user == null){
			// 若是登陆，当用户名和密码为空时则跳转到出错页面
			if(userName == null || password == null){
				request.getRequestDispatcher("/Common/error/error.jsp").forward(request, response);
			} 
			else {
				
		  // 查询所有的用户
				user  = ud.queryUser(userName); // 得到所有用户
				
				System.out.println(user);//后台输出用户名
				if(user == null){
					isIn = false;
				} 
				else {
					if(user.getPass().equals(password)){
						isIn = true;
						if(user.getRole()==1) {
							isManager = true;
						}
					} 
				}
			}
			
		} else {
			isIn = true;
		}
		
		
		// 如果合法，显示用户订单信息
		if (isIn) {
			// 若是管理员，则设置相应的标志，查询用户
			if(isManager){
				session.setAttribute("user", ud.queryUser(userName));
				response.sendRedirect("/BookShop/com/bsw/manager/managerWelcome.jsp");
			} else {
				// 若是用户，则查询用户
				UserDAO userDAO = new UserDAO();
				User userDetail = userDAO.queryUser(user.getName());
				// 放入会话对象，便于以后得到用户名
				session.setAttribute("user", userDetail);
				BookDAO bookDAO = new BookDAO();
				ArrayList books = bookDAO.queryNewBooks();
				request.setAttribute("books", books);
				request.getRequestDispatcher("/com/bsw/user/loginSuccess.jsp").forward(request, response);
			}
		}

		// 没有登陆，跳到出错页面
		else {
			request.getRequestDispatcher("/com/bsw/error/error.jsp").forward(
					request, response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
