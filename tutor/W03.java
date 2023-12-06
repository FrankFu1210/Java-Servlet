package tw.frank.tutor;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//測試連線後console出現W03() init() service() GET等關係，重新編譯後沒有物件所以抓建構式初始化一次，然後去抓參數，運用Enumeration getParameterNames 
@WebServlet("/W03")
public class W03 extends HttpServlet {
	public W03() {//重寫code會重新編譯，沒有物件所以找建構式
		System.out.println("W03()");
	}	//完成編譯但是，new叫出來(建構式)所以創造物件實體，之後物件會一直存在到server掛掉
	//物件不是新的，建構式就不會出現
	//物件有哪些東西需要初始化一次而已，除非很多屬性	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service()");
//		super.service(req, resp);//關掉就沒有下去，doGet回不來
		System.out.println(req.getMethod()); //直接寫在裡面GET POST都拿得到! 可以用equals來分辨
	}

	//建構式處理物件初始化init()，去抓參數
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
		super.init(config);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String param = params.nextElement();//泛型字串接受，等下旬訪
			String value = request.getParameter(param);//用name取得value
			System.out.printf("%s : %s\n", param, value);
			//參數null何來物件方法
			//一開始沒元素沒參數，網頁可以接收參數後面加上?k=v&k=v... 如?x=5&y=7
			//(通用型後端什麼都收)
		}
		System.out.println("-----");		
	}
}
