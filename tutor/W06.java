package tw.frank.tutor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//檔案上傳到伺服器後要搬移用post，將檔案搬到風水好想要的地方，運用@MultipartConfig, getPart, getName, getSize, getSubmittedFileName, getContentType
@WebServlet("/W06")//key=value省略
//@MultipartConfig(location = "C:\Users\17E2\eclipse-workspace\web\ upload") //能上傳的加一個宣告，肚子裝值 相對路徑
@MultipartConfig //能上傳的加一個宣告，肚子裝值 相對路徑
public class W06 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("upload");//純粹物件實體
		System.out.println(part.getName());//進湯姆貓後一般不會用用戶端原檔名
		System.out.println(part.getSize());
		System.out.println(part.getSubmittedFileName());//沒上傳會顯示空字串
		System.out.println(part.getContentType());//解讀不出來會顯示application/octet-stream
	
//		request.getInputStream()//父類檔servelet inputstream串流不玩
		
		//沒有處理檔案上傳，因為伺服器會做放到暫存區(組態檔可設定)，我們拿位置搬過來
		if (part.getSize() > 0) {
//			part.write(part.getSubmittedFileName());
			part.write("C:\\Users\\17E2\\eclipse-workspace\\web\\upload\\" + part.getSubmittedFileName());//絕對路徑
		}
	}
}
// 組態檔可做設定，變更一次就好，每次都去那
// URL location
// 在init就把組態檔搬回來招式更強!
