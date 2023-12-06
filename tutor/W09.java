package tw.frank.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//輸出過去給W08做廣告頁面，運用getAttribute
@WebServlet("/W09")
public class W09 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
//		Object xx = request.getAttribute("x");//物件xx
		String xx = (String) request.getAttribute("x");//強制轉型成String
		String yy = (String) request.getAttribute("y");//強制轉型成String
		
		PrintWriter out = response.getWriter();
		out.print("Im from W09<hr />");
		if (name != null) {
			out.print("This is &nbsp" + name + "<hr />");//要在http://localhost:8080/web/W08網頁後面輸入?name=Leo		
		}
		out.printf("%s%s", xx, yy);//中間要,不是+...
	}
}
//request來自W08，拿request的物件繼續處理
//明天看大咖的全轉向MVC (springboot)
