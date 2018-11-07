<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"
	import="java.util.List"%>
<%@ page import="java.util.List"%>
<%@ page
	import="com.valunskii.foxminded.university.repository.entity.Classroom"%>
<%@ page
	import="com.valunskii.foxminded.university.repository.entity.Subject"%>
<%@ page
	import="com.valunskii.foxminded.university.repository.entity.Teacher"%>
<%@ page
	import="com.valunskii.foxminded.university.repository.entity.Group"%>
<%@ page
	import="com.valunskii.foxminded.university.repository.entity.Student"%>
<%@ page
	import="com.valunskii.foxminded.university.repository.entity.Schedule"%>
<%@ page
	import="com.valunskii.foxminded.university.repository.entity.Lecture"%>
<%@ page
	import="com.valunskii.foxminded.university.repository.entity.Parity"%>


<%@ page
	import="com.valunskii.foxminded.university.service.ClassroomService"%>
<%@ page
	import="com.valunskii.foxminded.university.service.SubjectService"%>
<%@ page
	import="com.valunskii.foxminded.university.service.TeacherService"%>
<%@ page
	import="com.valunskii.foxminded.university.service.GroupService"%>
<%@ page
	import="com.valunskii.foxminded.university.service.StudentService"%>
<%@ page
	import="com.valunskii.foxminded.university.service.ScheduleService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FoxUniversity</title>
</head>
<body>
	<h1>Добро пожаловать в наш Университет!</h1>

	<h2>Наши аудитории:</h2>

	<%
	    List<Classroom> rooms = ClassroomService.getAllClassrooms();
	    for (Classroom room : rooms) {
	        out.println("<p> - " + room.getName() + "</p>");
	    }
	    out.println("<p> (всего: " + rooms.size() + ")</p>");
	%>

	<h2>Наши предметы:</h2>

	<%
	    List<Subject> subjects = SubjectService.getAllSubjects();
	    for (Subject subject : subjects) {
	        out.println("<p> - " + subject.getName() + "</p>");
	    }
	    out.println("<p> (всего: " + subjects.size() + ")</p>");
	%>

	<h2>Наши преподаватели:</h2>

	<%
	    List<Teacher> teachers = TeacherService.getAllTeachers();
	    for (Teacher teacher : teachers) {
	        out.println("<p> - " + teacher.getLastName() + " " + teacher.getFirstName() + " "
	                + teacher.getMiddleName() + "<em> (id= " + teacher.getId() + ")</em></p>");
	    }
	    out.println("<p> (всего: " + teachers.size() + ")</p>");
	%>

	<h2>Наши группы:</h2>

	<%
	    List<Group> groups = GroupService.getAllGroups();
	    for (Group group : groups) {
	        out.println("<p> - " + group.getName() + "</p>");
	    }
	    out.println("<p> (всего: " + groups.size() + ")</p>");
	%>

	<h2>Наши студенты:</h2>

	<%
	    List<Student> students = StudentService.getAllStudents();
	    for (Student student : students) {
	        out.println("<p> - " + student.getLastName() + " " + student.getFirstName() + " "
	                + student.getMiddleName() + "<em> (id= " + student.getId() + ")</em></p>");
	    }
	    out.println("<p> (всего: " + students.size() + ")</p>");
	%>

	<h2>Расписание университета:</h2>

	<%
	    List<Schedule> schedule = ScheduleService.getAllSchedule();
	    for (Schedule row : schedule) {
	        out.println("<p><strong>" + row.getDayOfWeek() + " " + row.getParity() + " " + row.getLesson()
	                + "</strong></p>");
	        for (Lecture lecture : row.getLectures()) {
	            out.println("<p><em>- " + lecture.getSubject().getName() + " " + lecture.getTeacher().getLastName()
	                    + " / " + lecture.getGroup().getName() + " / " + lecture.getClassroom().getName()
	                    + "</em></p>");
	        }
	        System.out.println();
	    }
	%>

</body>
</html>