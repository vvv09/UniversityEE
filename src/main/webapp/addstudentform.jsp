<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Student</title>
</head>
<body>
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
        </table>

        <p>
            <input type="submit" name="submit" value="Добавить студента" />
        </p>
    </form>
</body>
</html>
