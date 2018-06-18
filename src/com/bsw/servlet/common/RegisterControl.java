package com.bsw.servlet.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsw.user.User;
import com.bsw.user.UserDAO;

/**
 * 继承 HttpServlet 类
 * 实现显示图书详细信息的功能
 * 
 * @author Student
 * @version 1.0.0
 */
public class RegisterControl extends HttpServlet {

	/**
	 * 无参构造函数
	 */
	public RegisterControl() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
	 * @throws ParseException 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		User user = new User();
		UserDAO userDAO = new UserDAO();
		String name = request.getParameter("Wname");
		
			// 假若在数据库中查到，则设置用户的属性
			if(userDAO.queryUser(name)==null){
				user.setName(name);
				user.setPass(request.getParameter("password"));
				user.setRealName(request.getParameter("realname"));
				user.setGender(request.getParameter("gender"));
				user.setAge(Integer.parseInt(request.getParameter("age")));
				user.setEmail(request.getParameter("email"));
				user.setPhone(request.getParameter("commMethod"));
				user.setAddress(request.getParameter("address"));
				DateFormat d = DateFormat.getDateInstance();
				try{
					Date date = new Date(d.parse(request.getParameter("registTime")).getTime());
					user.setRegisterTime(date);
					userDAO.insertUser(user);
				}catch(ParseException e){
					e.printStackTrace();
				}
				response.sendRedirect("/BookShop/com/bsw/user/registerSuccess.jsp");
			}else{
				User tempUser = new User();
				tempUser.setRealName(request.getParameter("realname"));
				tempUser.setGender(request.getParameter("gender"));
				tempUser.setAge(Integer.parseInt(request.getParameter("age")));
				tempUser.setEmail(request.getParameter("email"));
				tempUser.setPhone(request.getParameter("commMethod"));
				tempUser.setAddress(request.getParameter("address"));
				request.setAttribute("userTemp",tempUser);
				request.getRequestDispatcher("/com/bsw/user/registerUnsuccess.jsp").forward(request, response);
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
