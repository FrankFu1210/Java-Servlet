package tw.frank.tutor;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//此JAVA已經與伺服器連線，用瀏覽器開啟後回到console可以看到localhost:8080 Google Chrome accept-language : zh-TW等相關資訊，運用nextElement getHeader
@WebServlet("/W02")
public class W02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();//泛型字串接受，等下旬訪
			String value = request.getHeader(name);//用name取得value， " getDateHeader "返回指定名称的Data类型的HTTP头的信息，返回所有HTTP头的名称的集合
			System.out.printf("%s : %s\n", name, value);
			//沒有網頁命令列仍存在可sysoutprint在console出現
			//重啟 編譯 讓用戶對他發生請求 被做 在console看到 結束
			//cache-control : max-age=0 有效賞味期0 馬上失效沒有放記憶體空間
		}
		System.out.println("-----");
		
	}
//參數null何來物件方法
	//沒元素沒參數 可以接收參數 ?k=v&k=v...
}
