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
		
		//因為一開始xy沒有輸入，"myCalc"會變成null，變成第2個例外被拋出，程式就結束了所以不會到html顯示畫面，將這句往下移動到try catch裡面拋出例外
//		MyCalc myCalc = (MyCalc) request.getAttribute("myCalc");//接收W12 "myCalc"
		
		//這邊再去寫一個串流工具箱Utils，要載入畫面的class方法
		
		//從Utils回到W13來loadView()，輸出畫面try catch交給他合理，再回到W12去看關鍵字 "myCalc"
		String web = "";//拋出例外後下方web需要被initialized，給他空字串
		try {
			MyCalc myCalc = (MyCalc) request.getAttribute("myCalc");//接收W12 "myCalc"
//			String web = Utils.loadView("view1");//宣告字串Web名稱參考至"view1"物件
			web = Utils.loadView("view1");
			out.printf(web, myCalc.getX(), myCalc.getY(), myCalc.plus());//到這邊第一階段設定已經完成~去W12跑網頁是空白，來debug
			
		} catch (Exception e) {
			System.out.println(e);//第2個例外在這邊被拋出 Cannot invoke "tw.frank.utils.MyCalc.getX()" because "myCalc" is null
			out.printf(web, "", "", "");//當例外發生變成空字串，由於web在try catch內宣告外面不認識，將web移至外面宣告
		}
	}
}