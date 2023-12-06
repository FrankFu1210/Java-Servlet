package tw.frank.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//面對網頁，可以把整個html原始碼搬過來，運用private final String
@WebServlet("/W04")
public class W04 extends HttpServlet {
	private final String html = "<!DOCTYPE html>\r\n"
			+ "<html>\r\n"
			+ "	<head>文件結構樹狀圖\r\n"
			+ "		<meta charset='UFT-8'>\r\n"
			+ "		<title>Insert title here</title>\r\n"
			+ "	</head>\r\n"
			+ "	<body>\r\n"
			+ "		<form action='W04'>\r\n"
			+ "			/*結尾 自我了結 預設type text*/\r\n"
			+ "			<input name='x' value='%s' />\r\n"
			+ "			+\r\n"
			+ "			<input name='y' value='%s' />\r\n"
			+ "			<input type='submit' value='='>\r\n"
			+ "			<span>%s</span>\r\n"
			+ "		</form>\r\n"
			+ "	\r\n"
			+ "	</body>\r\n"
			+ "</html>";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		System.out.printf("%s : %s", x, y);//東西進來再運算 命令列out
		
		
		
		response.setContentType("text/html; charset=UTF-8"); //輸出內容以下是什麼文件
		PrintWriter out = response.getWriter();//網頁out
		
		try {
			int r = Integer.parseInt(x) + Integer.parseInt(y);
//		response.getWriter().printf("%s + %s = %s", x, y, r);
//		out.printf("%s + %s = %s", x, y, r);
		out.printf(html, x, y, r);
		}catch(RuntimeException e) {
			out.printf(html, "", "", "");
		}
	}
}
// 將數字57改為文字，ERROR 500 內部錯誤，邏輯問題
// 伺服器還活者，請求拋出例外
