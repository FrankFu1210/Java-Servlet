package tw.frank.tutor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.frank.utils.MyCalcV2;

//MVC版57，加上+-*/
@WebServlet("/W12V2")
public class W12V2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");		
		
		//1.接收參數
		String x = request.getParameter("x");
		String y = request.getParameter("y");
//		String op = request.getParameter("op");//加上參數op，把參數op從W12V2搬到W13V2去做
		
		//2.計算
		try {
			MyCalcV2 myCalcV2 = new MyCalcV2(x, y);
			request.setAttribute("myCalcV2", myCalcV2);//setAttribute(String name, Object o)
//			request.setAttribute("view", "view1");//加入"view1"，然後去W13V2設定，將"view1"調整到下面VIEW呈現
		} catch (Exception e) {
			System.out.println(e); 
		}
		
		//3.呈現VIEW
		request.setAttribute("view", "view2");//"view1"可以在這邊自由更換版本"view1 view2 view3"都行
		RequestDispatcher dispatcher = request.getRequestDispatcher("W13V2");
		dispatcher.forward(request, response);
	
	}
}
//1207 111925卡關
//1207 112926改V3

