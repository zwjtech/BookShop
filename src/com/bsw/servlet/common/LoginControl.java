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
 * �����̨����
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

		// �����ַ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		UserDAO ud = new UserDAO();
		
		//���ñ�־λ
		boolean isIn = false;
		boolean isManager =false;
		HttpSession session = request.getSession();
		
		// ��ȡ����
		User user = (User)session.getAttribute("user");
		String userName = request.getParameter("userName");
		//System.out.println("userName="+userName);//test,�����ַ����������
		
		String password = request.getParameter("pwd");
		//String userName =new String(request.getParameter("userName").getBytes("ISO-8859-1"),"utf-8");
		
		System.out.println("userName="+userName);//test,�����ַ����������
		
		// �ж��û��ǵ�½�����Ǵ�����ҳ����ת����ҳ���
		if(user == null){
			// ���ǵ�½�����û���������Ϊ��ʱ����ת������ҳ��
			if(userName == null || password == null){
				request.getRequestDispatcher("/Common/error/error.jsp").forward(request, response);
			} 
			else {
				
		  // ��ѯ���е��û�
				user  = ud.queryUser(userName); // �õ������û�
				
				System.out.println(user);//��̨����û���
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
		
		
		// ����Ϸ�����ʾ�û�������Ϣ
		if (isIn) {
			// ���ǹ���Ա����������Ӧ�ı�־����ѯ�û�
			if(isManager){
				session.setAttribute("user", ud.queryUser(userName));
				response.sendRedirect("/BookShop/com/bsw/manager/managerWelcome.jsp");
			} else {
				// �����û������ѯ�û�
				UserDAO userDAO = new UserDAO();
				User userDetail = userDAO.queryUser(user.getName());
				// ����Ự���󣬱����Ժ�õ��û���
				session.setAttribute("user", userDetail);
				BookDAO bookDAO = new BookDAO();
				ArrayList books = bookDAO.queryNewBooks();
				request.setAttribute("books", books);
				request.getRequestDispatcher("/com/bsw/user/loginSuccess.jsp").forward(request, response);
			}
		}

		// û�е�½����������ҳ��
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
