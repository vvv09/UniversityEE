<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
</head>
<body>
<h1>Внесите требуемые изменения</h1>
<form action="editStudentServlet" method="post">
<input type="hidden" name="id" value="<c:out value="${student.id}"/>"/>
<table>
<tr><td>Фамилия:</td><td><input type="text" name="lastName" value="<c:out value="${student.lastName}"/>"/></td></tr>
<tr><td>Имя:</td><td><input type="text" name="firstName" value="<c:out value="${student.firstName}"/>"/></td></tr>
<tr><td>Отчество:</td><td><input type="text" name="middleName" value="<c:out value="${student.middleName}"/>"/></td></tr>
<tr><td>Группа:</td><td><input type="text" name="group" value="группе быть"/></td></tr>
</table>
<p>
<input type="submit" value="Сохранить изменения"/>
</p>
</form>
</body>
</html>
