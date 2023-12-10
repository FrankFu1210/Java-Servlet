package tw.frank.utils;
//MyCalc API，加上+-*/，將計算option功能從W13V2搬到MyCalcV3 (計算屬於計算機功能)
public class MyCalcV3 {
	private int x, y, op;

	public MyCalcV3(String x, String y, String op) throws Exception{
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
		this.op = Integer.parseInt(op);
	}
	
	public String result() {//在MyCalcV3宣告為result()，去W13V3將result = ""修改為myCalcV3.result()
		switch (op) {
		case 0: return plus() + ""; //這邊return回到plus()，不能加break，不然會變成Unreachable code
		case 1: return minu() + ""; 
		case 2: return mult() + ""; 
		case 3: return div() + ""; 
		default: return "";
		}		
	}
	public int plus() {
		return x + y;
	}
	public int minu() {
		return x - y;
	}
	public int mult() {
		return x * y;
	}

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
	public int getOp() {//加入getOp()
		return op;
	}
}


