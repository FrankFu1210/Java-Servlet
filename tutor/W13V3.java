package tw.frank.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.frank.utils.MyCalcV2;
import tw.frank.utils.MyCalcV3;
import tw.frank.utils.UtilsV2;

//W13是VIEW，加上+-*/
@WebServlet("/W13V3")
public class W13V3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setContentType("text/html; charset=UTF-8");		
		PrintWriter out = response.getWriter();
		
		String web = "";
		try {
			MyCalcV3 myCalcV3 =  (MyCalcV3) request.getAttribute("myCalcV3");
			
			String view = (String) request.getAttribute("view"); 
			web = UtilsV2.loadView(view);
			
//			String op = request.getParameter("op");
			String[] ops = {"", "", "", ""};
			
//			String result = "";
			String result = myCalcV3.result();//改成myCalcV3.result()
			
//			if (op != null) {//op已經在W12V3被new MyCalcV3(x, y, op) try catch拋出，不用再if
//				ops[myCalcV3.getOp()] = "selected";
//			}
			
			ops[myCalcV3.getOp()] = "selected";
			
//			web = UtilsV2.loadView(view);//debug!! 需將此段loadView調整到result之上方，不然會出現MyCalcV3.result()" because "myCalcV3" is null 		
			
			out.printf(web, myCalcV3.getX(), ops[0], ops[1], ops[2], ops[3], myCalcV3.getY(), result);//或者把result = myCalcV3.result()替換，再印出也可以(等於移下來)
//			out.printf(web, myCalcV3.getX(), ops[0], ops[1], ops[2], ops[3], myCalcV3.getY(), myCalcV3.result());
			
		} catch (Exception e) {
			System.out.println("debug1" + e);
			out.printf(web, "", "", "", "", "", "", "");
		}
	}
}
//更聰明方法把op建構式，然後 用string帶去MyCalc計算
//多重例外寫在同一種可以，但是要小心順序性!
	
//明天後端要做的事，用程式畫圖

