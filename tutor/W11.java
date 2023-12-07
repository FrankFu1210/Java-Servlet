package tw.frank.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.frank.utils.Bike;

//連結W10 & W11所呈現的網頁內容，getAttribute強制轉型回腳踏車(物件)
@WebServlet("/W11")
public class W11 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Bike b1 = (Bike)request.getAttribute("bike");//Bike在W10被初始化，這裡沒有，強制轉型回腳踏車(物件)
		//現在b1是還沒被初始化的物件null，所以直接打開會顯示Cannot invoke "tw.frank.utils.Bike.getSpeed()" because "b1" is null
		
		PrintWriter out = response.getWriter();
		out.println("I am W11<hr />" + b1.getSpeed() + "<hr />");
	}

}
//定義 宣告 初始化 3步驟，以下範例
//例如變數(Variable)：定義一個型態和名稱，用來在記憶體中暫時儲存資料，其值可以改變，使用前必須先宣告及初始化。
//宣告一個名為count的整數型態的變數
//https://notepad.yehyeh.net/Content/CPP/CH01/02Variable/1.php
