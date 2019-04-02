<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Groups List</title>
</head>
<body>

	<c:set var="truePage" value="${true_page}" />
	<c:if
		test="${(truePage == null) || (truePage != 'com.valunskii.foxminded.university.ui.GetGroupListServlet')}">
		<c:redirect url="getGroupListServlet" />
	</c:if>

	<h3>Группы</h3>
	<hr />
	<table width="50%">
		<c:forEach items="${groups}" var="g">
			<tr>
				<td>${g.name}</td>
				<td><a href="getGroupScheduleServlet?id=${g.getId()}">Посмотреть расписание</a></td>
				<td><a href="getGroupServlet?id=${g.getId()}">Править</a></td>
				<td><a href="deleteGroupServlet?id=${g.getId()}">Удалить</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<em>(всего: ${fn:length(groups)})</em>
	</p>
	<hr />
	<p>
		<em><a href="addgroupform.jsp">Добавить группу</a></em>
	</p>
	<p>
		<em><a href="index.jsp">На главную</a></em>
	</p>
</body>
</html>
