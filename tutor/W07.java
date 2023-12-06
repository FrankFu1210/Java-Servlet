package tw.frank.tutor;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//多個檔案上傳到伺服器後要搬移用post，將檔案搬到風水好想要的地方，運用@MultipartConfig, getParts
@WebServlet("/W07")//key=value省略
@MultipartConfig(location = "C:\\Users\\17E2\\eclipse-workspace\\web\\upload") //能上傳的加一個宣告，肚子裝值 相對路徑

public class W07 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<Part> parts = request.getParts();//多物件實體
		
		for (Part part: parts) {
			String type = part.getContentType();//區分一般的&檔案上傳的，可判斷null
			if (type != null && part.getSize() > 0) {
				part.write(part.getSubmittedFileName());
			}
		}

	}
}
