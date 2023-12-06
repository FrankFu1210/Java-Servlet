package tw.frank.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//表單選項提交連結伺服器，用陣列將相同特性變數名稱傳遞，多個參數values變字串陣列，運用String[] getParameter getParameterValues 
@WebServlet("/W05")
public class W05 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String pcode = request.getParameter("pcode");
		String[] hobby = request.getParameterValues("hobby"); //用陣列將相同特性變數名稱傳遞，多個參數values變字串陣列
		
		response.setContentType("text/html; charset=UTF-8");//Type打錯串流瀏覽器會不認識，視為普通一般檔案下載動作! 下載串流...
		PrintWriter out = response.getWriter();
		out.append(account).append(":" + passwd).append(":" + gender).append(":" + pcode + "<br />");//可以一直append接下去
		for (String h : hobby) {
			out.append(h);
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
