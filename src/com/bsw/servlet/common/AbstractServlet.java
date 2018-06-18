package com.bsw.servlet.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bsw.user.User;

/**
 * �Զ������ Servlet���̳� HttpServlet ��
 * �г��󷽷� execute��doPost ��������ʵ�ַǷ�����
 * 
 * @author Student
 *
 */
public abstract class AbstractServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AbstractServlet() {
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
		// �����ַ���
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		// �ж��û��Ƿ�Ƿ���½
		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("user");
	 	if(user == null){
	 		out.println("<center><br><br>����û�е�¼�����ȵ�¼<br>");
			out.println("<a href=/BookShop/servlet/WelcomeControl \" target = \"_top\"/>���ص�¼����</a></center>");
			return;
	 	}
 		execute(request, response);
	}

	/**
	 * The execute method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
