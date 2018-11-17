<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subject List</title>
</head>
<body>

	<c:set var="truePage" value="${true_page}" />
	<c:if
		test="${(truePage == null) || (truePage != 'com.valunskii.foxminded.university.ui.GetSubjectListServlet')}">
		<c:redirect url="getSubjectListServlet" />
	</c:if>

	<h3>Предметы</h3>
	<hr />
	<table width="50%">
		<c:forEach items="${subjects}" var="s">
			<tr>
				<td>${s.name}</td>
				<td><a href="getSubjectServlet?id=${s.getId()}">Править</a></td>
				<td><a href="deleteSubjectServlet?id=${s.getId()}">Удалить</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<em>(всего: ${fn:length(subjects)})</em>
	</p>
	<hr />
	<p>
		<a href="addsubjectform.jsp">Добавить предмет</a>
	</p>
	<p>
		<em><a href="index.jsp">На главную</a></em>
	</p>
</body>
</html>
