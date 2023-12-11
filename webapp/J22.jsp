<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String start = request.getParameter("start");
	String rows = request.getParameter("rows");
	String cols = request.getParameter("cols");
	
	final int START = start == null || start == "" ? 2 : Integer.parseInt(start);
	final int ROWS = rows == null || rows == "" ? 2 : Integer.parseInt(rows);
	final int COLS = cols == null || cols == "" ? 4 : Integer.parseInt(cols);
	
%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>複習99乘法表，並將網頁變成可自由輸入table格式! 1208 114358 教樂樂寫:)</title>
	</head>
	<body>
	<script type="text/javascript">
		function checkForm(){
			
			return true;
		}
	</script>
	
		<form onsubmit="return checkedForm();">
			Start from: <input type = "number" name = "start">
			<input type = "number" name = "rows">
			x
			<input type = "number" name = "cols">
			<input type = "submit" value = "Change Table" />
		</form>
		<hr />
	
		<table border="1" align="center" valign="middle">
			
				<% 
// 					for (int l=0; l<2; l++) {						
					for (int l=0; l<ROWS; l++) {						
						out.print("<tr>");
						
// 							for (int k=2; k<6; k++) {
							for (int k=START; k<START+COLS; k++) {
// 									int z = k + 4*l;
									int z = k + COLS*l;
								out.print("<td>");
									
								for (int i=1; i<10; i++) {
									int j = z*i;
									out.print(String.format("%d * %d = %d<br />", z, i, j));
								}
								out.print("</td>");
							}
						out.print("</tr>");
					}
				%>					

		</table>
	</body>
</html>

<% 
//頁面原始碼都可以由後端動態產生
//接收參數，參數永遠是字串
//HW: td BG color 黃粉紅 粉紅黃 馬賽克效果 CSS

//onclick也可以return t/f
%>