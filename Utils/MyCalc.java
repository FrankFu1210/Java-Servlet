package tw.frank.utils;
//MyCalc API
public class MyCalc {
	private int x, y;
	//配合CTL收到字串，屬性自己規劃，可能會有字串/整數問題，以例外拋出
	public MyCalc(String x, String y) throws Exception{
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}
	public int plus() {//x+y
		return x + y;
	}
	
	//Shift+Alt+S +r: Getters & Setters
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

}

//parseInt() 方法用于将字符串参数作为有符号的十进制整数进行解析。
//如果方法有两个参数， 使用第二个参数指定的基数，将字符串参数解析为有符号的整数。
//parseInt(String s): 返回用十进制参数表示的整数值。
//parseInt(int i): 使用指定基数的字符串参数表示的整数 (基数可以是 10, 2, 8, 或 16 等进制数) 。
//https://www.runoob.com/java/number-parseint.html

