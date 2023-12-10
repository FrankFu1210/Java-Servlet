package tw.frank.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//串流工具箱UtilsV2
public class UtilsV2 {
	public static String loadView(String view) throws Exception {			

		String viewFolder = "C:\\Users\\17E2\\eclipse-workspace\\web\\src\\main\\webapp\\views\\";
		File viewFile = new File(viewFolder + view + ".html");
		
		BufferedReader reader = new BufferedReader(new FileReader(viewFile));
		
		String line; 
		StringBuffer sb = new StringBuffer();		

		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");//加入"\n"
		}
		reader.close(); 
		
		return sb.toString();
	}
}

