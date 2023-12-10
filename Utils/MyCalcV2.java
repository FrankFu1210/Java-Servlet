package tw.frank.utils;
//MyCalc API，加上+-*/
public class MyCalcV2 {
	private int x, y;
	//配合CTL收到字串，屬性自己規劃，可能會有字串/整數問題，以例外拋出
	public MyCalcV2(String x, String y) throws Exception{
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}
	public int plus() {
		return x + y;
	}
	public int minu() {//增加-*/，然後去W13V2調整MyCalcV2
		return x - y;
	}
	public int mult() {
		return x * y;
	}
//	public int div() {//需要將int換成String type
	public String div() {
		int z1 = x / y;
		int z2 = x % y;
		return String.format("%d...%d", z1, z2);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}


