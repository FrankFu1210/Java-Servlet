package tw.frank.tutor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HiLeo")//請求
public class HiLeo extends HttpServlet {//類別針對requesr處理，都是server做的
	//doGet方法備處發後該做什麼事
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {//括號下面為要做的事
		//server設定文件&路徑 (程式有語法對跟錯，文件(HTML)沒有)
		//用URL來doGet (不要跟URL檔名，跟類別名稱一樣的安全機制)
		//玩request & response這2個物件
		response.getWriter().append("Served at: Leo ").append(request.getContextPath());
	}

}
//相對路徑src/main/java 中 tw.frank.tutor
//log紀錄年月日時分秒做什麼事
//404代表server有回應，只是東西放錯地方而已
//JAVA SE EE ME api
//網頁後面可接?k=v&k=v... 如?x=5&y=7 或 ?name=Leo
