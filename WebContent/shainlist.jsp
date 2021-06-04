<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.ShainListBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員リスト</title>
</head>
<body>
	ログイン社員名：<%=bean.getLoginShainName()%><br> メッセージ：<%=bean.getMsg()%><br>

	社員リスト:
	<br>
	<table border="1" width="500" cellspacing="0" cellpadding="5"
		bordercolor="#333333">
		<tr>
			<th>社員名</th>
			<th>メールアドレス</th>
		</tr>


		<%
		for (dao.EmployeesVo emp : bean.getShainList()) {
		%>
		<tr>
			<td><%=emp.getEmployeename()%> <br></td>
			<td><%=emp.getEmail()%></td>
		</tr>

		<%
		}
		%>
	</table>

	ID
	<input name="ID" type="text">
	<br>

	<form method="POST" action="NextServlet">
		次の画面へ<br> <input type="submit" value="次の画面へ">
	</form>



</body>
</html>