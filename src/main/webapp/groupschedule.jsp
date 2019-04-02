<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>group schedule</title>
</head>
<body>

    <c:set var="truePage" value="${true_page}" />
    <c:if
        test="${(truePage == null) || (truePage != 'com.valunskii.foxminded.university.ui.GetGroupScheduleServlet')}">
        <c:redirect url="index.jsp" />
    </c:if>

    <h3>Расписание для группы: ${group.name}</h3>
<hr />
    <form action="getGroupScheduleServlet" method="get">
        <input type="hidden" name="id" value="<c:out value="${group.id}"/>" />
        День недели: <select name="dayOfWeek">
            <option>ЛЮБОЙ</option>
            <option>MONDAY</option>
            <option>TUESDAY</option>
            <option>WEDNESDAY</option>
            <option>THURSDAY</option>
            <option>FRIDAY</option>
            <option>SATURDAY</option>
        </select> Четность недели: <select name="parity">
            <option>ЛЮБАЯ</option>
            <option>ODD</option>
            <option>EVEN</option>
        </select> <input type="submit" value="Фильтровать" />
    </form>
    <hr />
        <c:forEach items="${schedule}" var="row" varStatus="status">
        <p>
            <strong> ${row.dayOfWeek} ${row.parity} ${row.lesson} </strong>
        </p>
        <c:forEach items="${row.lectures}" var="l">
            <p>
                <em> ${l.subject.name} / ${l.teacher.lastName} / ${l.classroom.name}</em>
            </p>
        </c:forEach>
    </c:forEach>
    <hr />
    <p>
        <em><a href="getGroupListServlet">К списку групп</a></em>
    </p>
    <p>
        <em><a href="index.jsp">На главную</a></em>
    </p>
</body>
</html>
