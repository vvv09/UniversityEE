<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Subject</title>
</head>
<body>
	<h1>Введие название нового предмета</h1>
	<form action="addSubjectServlet" method="post">
		<table>
			<tr>
				<td>Название:</td>
				<td><input type="text" name="name" /></td>
			</tr>
		</table>
		<p>
			<input type="submit" name="submit" value="Добавить предмет" />
		</p>
	</form>
</body>
</html>
