<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Teacher</title>
</head>
<body>
	<h1>Введие данные о новом преподавателе</h1>
	<form action="addTeacherServlet" method="post">
		<table>
			<tr>
				<td>Фамилия:</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Имя:</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Отчество:</td>
				<td><input type="text" name="middleName" /></td>
			</tr>
		</table>
		<p>
			<input type="submit" name="submit" value="Добавить преподавателя" />
		</p>
	</form>
</body>
</html>
