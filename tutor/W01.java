package tw.frank.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//service分支doGet, doPost，運用PrintWriter getWriter()取得輸出串流(頁面文字)
@WebServlet("/W01")
public class W01 extends HttpServlet {
	private static final long serialVersionUID = 1L;//程式版本數long代表
       
    public W01() {//建構式做什麼事? 將該物件servelet進行初始化(多半針對屬性) (與網站連線要初始化分開)
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw = response.getWriter();//pw取得輸出串流(頁面文字)
		pw.append("Leo").append("\n$Rich$");//String, String Beauty
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); //需用PostMan或表單來測試
	}

}
