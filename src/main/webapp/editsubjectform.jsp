<%@page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<fmt:requestEncoding value="utf-8" />
<html>
<head>
<meta charset="UTF-8">
<title>Edit Subject</title>
</head>
<body>
    <h1>Внесите требуемые изменения</h1>
    <form action="editSubjectServlet" method="post" accept-charset="utf-8">
        <input type="hidden" name="id" value="<c:out value="${subject.id}"/>" />
        <table>
            <tr>
                <td>Название:</td>
                <td><input type="text" name="name"
                    value="<c:out value="${subject.name}"/>" /></td>
            </tr>
        </table>
        <p>
            <input type="submit" name="submit" value="Сохранить изменения" />
        </p>
    </form>
</body>
</html>
