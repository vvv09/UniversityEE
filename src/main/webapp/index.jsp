<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FoxUniversity</title>
</head>
<body>
	<h1>Добро пожаловать в наш Университет!</h1>
	<fieldset>
		<legend>Выберите раздел:</legend>
		<ul>
			<li><a href="getClassroomListServlet">Аудитории</a></li>
			<li><a href="getSubjectListServlet">Предметы</a></li>
			<li><a href="getTeacherListServlet">Преподаватели</a></li>
			<li><a href="getGroupListServlet">Группы</a></li>
			<li><a href="getStudentListServlet">Студенты</a></li>
			<li><a href="getUniversityScheduleServlet">Расписание</a></li>
		</ul>
	</fieldset>
</body>
</html>
