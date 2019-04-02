<%@page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<fmt:requestEncoding value="utf-8" />
<html>
<head>
<meta charset="UTF-8">
<title>Edit Teacher</title>
</head>
<body>
	<h1>Внесите требуемые изменения</h1>
	<form action="editTeacherServlet" method="post" accept-charset="utf-8">
		<input type="hidden" name="id" value="<c:out value="${teacher.id}"/>" />
		<table>
			<tr>
				<td>Фамилия:</td>
				<td><input type="text" name="lastName"
					value="<c:out value="${teacher.lastName}"/>" /></td>
			</tr>
			<tr>
				<td>Имя:</td>
				<td><input type="text" name="firstName"
					value="<c:out value="${teacher.firstName}"/>" /></td>
			</tr>
			<tr>
				<td>Отчество:</td>
				<td><input type="text" name="middleName"
					value="<c:out value="${teacher.middleName}"/>" /></td>
			</tr>
		</table>
		<p>
			<input type="submit" name="submit" value="Сохранить изменения" />
		</p>
	</form>
</body>
</html>
