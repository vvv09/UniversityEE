<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Student</title>
</head>
<body>
<c:set var="truePage" value="${true_page}" />
    <c:if
        test="${(truePage == null) || (truePage != 'com.valunskii.foxminded.university.ui.GetGroupsForNewStudentServlet')}">
        <c:redirect url="getGroupsForNewStudentServlet" />
    </c:if>
	<h1>Введие данные о новом студенте</h1>
	<form action="addStudentServlet" method="post">
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
			<tr>
				<td>Группа:</td>
				<td><select name="group">
						<c:forEach var="g" items="${groups}">
							<option value="${g.getId()}">${g.name}</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>

		<p>
			<input type="submit" name="submit" value="Добавить студента" />
		</p>

	</form>
</body>
</html>
