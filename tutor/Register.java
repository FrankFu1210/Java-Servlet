package tw.frank.tutor;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.frank.utils.MemberDB;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private MemberDB memberDB; //唯一註冊類別物件實體
	public Register() {//建構式初始化她
		try {
		memberDB = new MemberDB();
		}catch(Exception e) {
			
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);//將doPost本來的doGet(request, response)移上來，變成doPost
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String cname = request.getParameter("cname");
		
		try {
		memberDB.addNew(account, passwd, cname); //物件呼叫方法去做INSERT INTO動作
		
//		response.sendRedirect("J23.jsp");//回原表單
		response.sendRedirect("J24.jsp");//指向login表單
		
//		throw new SQLException();//測試ERROR 500使用
		} catch (SQLException e) {
			System.out.println(e);
		response.sendError(500, "Server Busy");//發生例外時假裝伺服器很忙...
	}
	}
}
//建完後，待MemberDB提供方法帶進來
//AES RSA加密相關 (上課用DCrypt)
//J23註冊表單連到會員資料庫 -> Register叫servlet登入，拿參數給MemberDB去作 -> MemberDB資料庫
//J24前端與sevlet搭配
//J25 改用jsp自己本身查詢，不離開