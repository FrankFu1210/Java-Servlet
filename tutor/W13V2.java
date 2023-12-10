package tw.frank.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.frank.utils.MyCalcV2;
import tw.frank.utils.UtilsV2;

//W13是VIEW，加上+-*/
@WebServlet("/W13V2")
public class W13V2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setContentType("text/html; charset=UTF-8");		
		PrintWriter out = response.getWriter();
		
		String web = "";
		try {
			MyCalcV2 myCalcV2 =  (MyCalcV2) request.getAttribute("myCalcV2");
			
			//從W12接收"view"
			String view = (String) request.getAttribute("view"); //將物件轉型(String)
			String op = request.getParameter("op");//加上參數op，把參數op從W12V2搬到W13V2去做
			
			String result = "";
			//用switch，並運用字串陣列!!!
			String[] ops = {"", "", "", ""};
			if (op != null) {
				switch (op) {
//				case "2": ops[1] = "selected"; break;//switch (op) null就被直接拋出了，沒有到這邊就break -> 加上if op != null
//				case "3": ops[2] = "selected"; break;//另外這邊寫break會變成值到這邊就停了，上方加入result並修改整個格式
//				case "4": ops[3] = "selected"; break;
				
				case "1": 
					ops[0] = "selected"; 
					result = myCalcV2.plus() + "";
					break;
				case "2": 
					ops[1] = "selected"; 
					result = myCalcV2.minu() + "";
					break;
				case "3": 
					ops[2] = "selected"; 
					result = myCalcV2.mult() + "";
					break;
				case "4": 
					ops[3] = "selected"; 
					result = myCalcV2.div();//這邊不能+ ""，會出現Format specifier '%s'錯誤
					break;
					
				default: ops[0] = "selected"; break;
				}
			}
			
//			web = Utils.loadView("view1");
			web = UtilsV2.loadView(view);//就可以將"view1"變成物件view，版本在W12V2進行切換			
			
//			out.printf(web, myCalcV2.getX(), ops[0], ops[1], ops[2], ops[3], myCalcV2.getY(), myCalcV2.plus());
			out.printf(web, myCalcV2.getX(), ops[0], ops[1], ops[2], ops[3], myCalcV2.getY(), result);//要換成結果!!
			
		} catch (Exception e) {
			System.out.println(e);
			out.printf(web, "", "", "", "", "", "", "");
		}
	}
}

