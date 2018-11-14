<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
</head>
<body>
	<c:set var="truePage" value="${true_page}" />
	<c:if
		test="${(truePage == null) || (truePage != 'com.valunskii.foxminded.university.ui.GetStudentForEditServlet')}">
		<c:redirect url="students.jsp" />
	</c:if>
	<h1>Внесите требуемые изменения</h1>
	<form action="editStudentServlet" method="post">
		<input type="hidden" name="id" value="<c:out value="${student.id}"/>" />
		<table>
			<tr>
				<td>Фамилия:</td>
				<td><input type="text" name="lastName"
					value="<c:out value="${student.lastName}"/>" /></td>
			</tr>
			<tr>
				<td>Имя:</td>
				<td><input type="text" name="firstName"
					value="<c:out value="${student.firstName}"/>" /></td>
			</tr>
			<tr>
				<td>Отчество:</td>
				<td><input type="text" name="middleName"
					value="<c:out value="${student.middleName}"/>" /></td>
			</tr>
			<tr>
				<td>Группа:</td>
				<c:set var="studentGroupId" value="${student.group.id}"/>
				<td><select name="group">
						<c:forEach var="g" items="${groups}">
							<option value="${g.id}" ${g.id == studentGroupId ? 'selected="selected"' : ''}>${g.name}</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>
		<p>
			<input type="submit" value="Сохранить изменения" />
		</p>
	</form>
</body>
</html>
