<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Classroom</title>
</head>
<body>
    <h1>Введие данные о новой аудитории</h1>
    <form action="addClassroomServlet" method="post">
        <table>
            <tr>
                <td>Название:</td>
                <td><input type="text" name="name" /></td>
            </tr>
        </table>
        <p>
            <input type="submit" name="submit" value="Добавить аудиторию" />
        </p>
    </form>
</body>
</html>
