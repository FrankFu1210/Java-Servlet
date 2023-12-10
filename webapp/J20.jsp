<%@ page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="J21.jsp" %>
<!-- 因為有指定errorPage(第4行)路徑，所以會跳到J21-->
<%
	String name = request.getParameter("name");
	name.charAt(0); //改成不傳參數，第7行name = null ->變成怎麼會有物件方法存在7,8行
	if (name == null) name = "World";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>將J20,J21連在一起，設計成在URL後面輸入?name=XX會出現J20內容</title>
	</head>
	<body>
		<h1>Brad Big Company</h1>
		<hr />
		<div>
		    <!-- 接收參數玩，應用於來自於後端的變數值 -->
			Welcome, <% out.print(name); %><!-- URL後面輸入?name=XX，J20就會出現了~ -->
			Welcome, <%= name %><!-- 上下2個name程式一樣，將out.print()簡寫為= -->
			<hr />
			Lottery: <%= (int)(Math.random()*49+1) %>
		</div>
		<hr />
		<%
			//大樂透出號碼用HashSet不會重複
			HashSet<Integer> set = new HashSet<>();//泛型 建構式 用while迴圈
			while (set.size() < 6){
				set.add((int)(Math.random()*49+1));
			}
			out.print(set);
		%>
	</body>
</html>

<% 
//*JSP寫前端 前後code交雜...
// <%標籤  網頁標籤就是作輸出的動作，從設計網頁出發
// @屬性指令 page + 屬性 + 值 

// 隱含物件，不用new就會出現 <% out.print("JAVA code");  = printwriter

// 標籤結束就死掉了，用setAttribute去做延伸 (Node section server端紀錄id來解決物件是否存在)
// applicaition針對整個網站非單一領域

// 由小到大存活空間Scope < page單頁 < request用戶端 < session伺服端(session ide關掉瀏覽器才掛) < application只要伺服器活著一直都在
%>

<!-- Eclipse下JSP加注释快捷鍵: ctrl+shift+c -->
<!-- 脚本 -->
<%-- 服务器端 --%>
