<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="tw.frank.utils.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mesg = "";

	request.setCharacterEncoding("UTF-8");
	String account = request.getParameter("account");	
	String passwd = request.getParameter("passwd");
	
	if (account != null && passwd != null){
		String SQL_LOGIN = "SELECT * FROM member WHERE account = ?";
		String URL = "jdbc:mysql://127.0.0.1/brad";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		Connection conn = DriverManager.getConnection(URL, prop);
		
		PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN);
		pstmt.setString(1, account);
		ResultSet rset = pstmt.executeQuery();
		if ( rset.next()) {
			String hashPasswd = rset.getString("passwd");
			if (BCrypt.checkpw(passwd, hashPasswd)) {
				response.sendRedirect("main.jsp");
			}else {
				mesg = "Login Failure";
			}
		}else {
			mesg = "Login Failure";
		}
	}
	
%>   
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>註冊單連到會員資料庫copy J24，但呼叫自己->百分比帶上去! 不透過servlet, jsp自己來~</title>
	</head>
	<body>
	<h1>Leo Company</h1>
	<hr />
	Login Form<br />
	<div><%= mesg %></div>
	<form>
		Account: <input name="account" /><br />
		Password: <input type="password" name="passwd" /><br />
		<input type="submit" value="Login" />
	</form>
	</body>
</html>
//1211 104643
import用* 包含package下面所有東西
->會員註冊也可以寫成這個版本
