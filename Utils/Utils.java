package tw.frank.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//串流工具箱Utils，要載入畫面的class方法
//將html view1檔案讀進來，變成字串後做return
//就是IO課!!!
public class Utils {
//	public static String loadView() throws Exception {//*調整一下，改為(String view)
	public static String loadView(String view) throws Exception {		
		
		//把views網址copy進來，以後只要修改view1 view2 view3檔案就好
		String viewFolder = "C:\\Users\\17E2\\eclipse-workspace\\web\\src\\main\\webapp\\views\\";
//		File viewFile = new File(viewFolder + "view1.html");//字串相加，*調整一下，改為view
		File viewFile = new File(viewFolder + view + ".html");
		
		//如何load view
		//BufferedReader一次讀一列串接
		BufferedReader reader = new BufferedReader(new FileReader(viewFile));
		
		String line; 
		StringBuffer sb = new StringBuffer();		

		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		reader.close(); //這邊不用try catch，直接上方拋出例外，做好後回到W13去loadView()
		
		return sb.toString();
	}
}

