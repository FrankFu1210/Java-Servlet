package tw.frank.tutor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.frank.utils.MyCalcV2;
import tw.frank.utils.MyCalcV3;

//MVC版57，加上+-*/，將計算option功能從W13V2搬到MyCalcV3 (計算屬於計算機功能)
@WebServlet("/W12V3")
public class W12V3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");		
		
		//1.接收參數
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String op = request.getParameter("op");
		
		//2.計算
		try {
			MyCalcV3 myCalcV3 = new MyCalcV3(x, y, op);
			request.setAttribute("myCalcV3", myCalcV3);
		} catch (Exception e) {
			System.out.println(e); 
		}
		
		//3.呈現VIEW
		request.setAttribute("view", "view3");
		RequestDispatcher dispatcher = request.getRequestDispatcher("W13V3");
		dispatcher.forward(request, response);
	
	}
}
//1207 111925卡關
//1207 112926改V3

