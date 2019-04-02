<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Classroom</title>
</head>
<body>
    <h1>Введие название новой группы</h1>
    <form action="addGroupServlet" method="post">
        <table>
            <tr>
                <td>Название:</td>
                <td><input type="text" name="name" /></td>
            </tr>
        </table>
        <p>
            <input type="submit" name="submit" value="Добавить группу" />
        </p>
    </form>
</body>
</html>
