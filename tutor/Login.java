package tw.frank.tutor;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.frank.utils.MemberDB;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private MemberDB memberDB; //唯一註冊類別物件實體
	public Login() {//建構式初始化她
		try {
		memberDB = new MemberDB();
		}catch(Exception e) {
			System.out.println("ERROR 2" + e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		
		try {//轉向要判斷
		if (memberDB.login(account, passwd)) { //物件呼叫方法去做INSERT INTO動作	
			response.sendRedirect("main.jsp");//去做一個main.jsp
		}else {
			response.sendRedirect("J24.jsp");
		}
//		throw new SQLException();
		} catch (SQLException e) {
			System.out.println("ERROR 1" + e);
		response.sendRedirect("J24.jsp");
		}
	}
}
