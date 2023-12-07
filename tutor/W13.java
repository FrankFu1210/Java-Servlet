package tw.frank.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.frank.utils.MyCalc;
import tw.frank.utils.Utils;

//W13是VIEW，版型來自view1，讀進來變文字內容，所以要呈現的動態重點地方放%s
//再寫一個Utils要載入畫面的工具程式class方法
@WebServlet("/W13")
public class W13 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//先去寫一個html view1，將網頁版型放進去
		
		response.setContentType("text/html; charset=UTF-8");		
		PrintWriter out = response.getWriter();
		
		MyCalc myCalc = (MyCalc) request.getAttribute("myCalc");//接收W12 "myCalc"
		
		//這邊再去寫一個串流工具箱Utils，要載入畫面的class方法
		
		//從Utils回到W13來loadView()，輸出畫面try catch交給他合理，再回到W12去看關鍵字 "myCalc"		
		try {
			String web = Utils.loadView("view1");
			out.printf(web, myCalc.getX(), myCalc.getY(), myCalc.plus());//到這邊第一階段設定已經完成~去W12跑網頁是空白，來debug
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
//更聰明方法把op建構式，然後 用string帶去MyCalc計算
//多重例外寫在同一種可以，但是要小心順序性!
	
//明天後端要做的事，用程式畫圖
