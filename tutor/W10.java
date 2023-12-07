package tw.frank.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.frank.utils.Bike;

//連結W10 & W11所呈現的網頁內容，include 與 forward 差別 (依據用戶端的請求，塞回別的結果內容)
@WebServlet("/W10")
public class W10 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("W11");
		
		Bike b1 = new Bike();
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1.getSpeed());
		
		//加入Bike到request屬性setAttribute身上
		request.setAttribute("bike", b1);
		
		PrintWriter out = response.getWriter();
		out.print("I am W10-1<hr />");//後端產生頁面原始碼
		
		dispatcher.include(request, response);//*當使用include，網頁內容會同時包含W10 & W11
		out.print("I am W10-2<hr />");
		
//		dispatcher.forward(request, response);//*當使用forward，網頁內容便會指向W11
//		out.print("I am W10-3<hr />");
	}
}
//MVC (springboot) 控制器的腳色 include全部，掌管到哪邊作，return回來可以指定到哪個地方做
//frame多半實現MVC，維護性/彈性很高
//Model演算法
//VIEW前端
//CTL轉發請求
