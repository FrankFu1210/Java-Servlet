package tw.frank.tutor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.frank.utils.MyCalc;

//MVC版57,先從CTL下手，然後設計MODEL，最後呈現VIEW
@WebServlet("/W12")
public class W12 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");		
		
		//CTL
		//1.接收參數
		//這邊編寫xy的參數是為了建立接收myCalc物件!
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		
		//2.計算商業邏輯，普通類別就好，撰寫工具包MyCalc(計算機)
		try {
			//先去MyCalc寫get/set，這邊myCalc物件身上挖不到
			//回來將MyCalc初始化，並且setAttribute
			MyCalc myCalc = new MyCalc(x, y);//這邊將xy塞進去就沒有W12的事，xy不用動
			request.setAttribute("myCalc", myCalc);//把物件用屬性Attribute方式帶走都行	，"myCalc"關鍵字複製，連到W13去設定       
		} catch (Exception e) {
			System.out.println(e); //第1個例外被拋出 Cannot parse null string
		}
		
		//3.呈現VIEW，寫W13 servlet
		request.setAttribute("view", "view1");//拉回CTL決定畫面的呈現，決定控制權，放上面原本的setAttribute("myCalc", myCalc)下面會因為myCalc初始值是null而一起被拋出!!!
		RequestDispatcher dispatcher = request.getRequestDispatcher("W13");
		dispatcher.forward(request, response);
	
	}
}
// MVC 
//MODEL演算法 MyCalc
// VIEW前端 W13 (html版型 view1, view2, view3) (IO串流工具包 Utils)
// CONTROLLER轉發請求 W12

//開啟順序1.W12 2.MyCalc 3.W13  4.view1 5.Utils (CMVVV)

//找出建構之程式結構的問題點!!!!! 有2個例外被拋出
//java.lang.NumberFormatException: Cannot parse null string
//1. 一開始沒有輸入x,y，值當然為null --> 繼續寫程式
//java.lang.NullPointerException: Cannot invoke "tw.frank.utils.MyCalc.getX()" because "myCalc" is null
//2. 為字串? --> 拋出例外 //寫到1207 104300
//沒物件沒關係，畫面可以呈現

//java.io.FileNotFoundException: C:\Users\USER\eclipse-workspace\web\src\main\webapp\views\view1.html (系統找不到指定的路徑。)
//因為學校電腦的路徑跟家裡電腦的不一樣啦...搞笑

/*Element.setAttribute()
设置指定元素上的某个属性值。如果属性已经存在，则更新该值；否则，使用指定的名称和值添加一个新的属性。
https://developer.mozilla.org/zh-CN/docs/Web/API/Element/setAttribute

 * 
*/

//readLine會把換列符號拿掉，原始碼一條線
