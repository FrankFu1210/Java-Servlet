package tw.frank.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 建立其他Java網頁連線(W09)，運用getRequestDispatcher, setAttribute
@WebServlet("/W08")
public class W08 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("W09");//物件先撈出來還沒作用，外面來的都叫用戶端參數，不要去變更她
		
		//值，參數拿到外面去做
		request.setAttribute("x", "5");
		request.setAttribute("y", "7");
		
		response.setContentType("text/html; charset=UTF-8");		
		PrintWriter out = response.getWriter();
		
		out.print("<h1>$LEO RICH$</h1>");
		out.print("<h1>:)</h1>");
		
		dispatcher.include(request, response);
		
		out.print("$RICH$");
//		out.flush();
		
//		response.flushBuffer();	
	}
}
//沒請求沒物件實體，第一次跑比較慢	
