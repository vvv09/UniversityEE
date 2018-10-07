package com.valunskii.foxminded.university.domain;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.valunskii.foxminded.university.dao.DaoFactory;
import com.valunskii.foxminded.university.dao.GroupDao;
import com.valunskii.foxminded.university.dao.postgres.PostgreSQLDaoFactory;

public class UniverstiyStart {

    private static University itmo;

    public static void main(String[] args) throws SQLException {

        showUniversity();

//        createUniversitySchedule();
//        showUniversitySchedule();
//        showStudentSchedule();
//        showTeacherSchedule();
//        showStudentScheduleForDay();
//        showTeacherScheduleForDay();
    }

    private static void showUniversity() throws SQLException {
        
        System.out.println("Список всех групп в университете:");
        DaoFactory daoFactory = new PostgreSQLDaoFactory();
        List<Group> list;
        try(Connection connection = daoFactory.getConnection()) {
            GroupDao groups = daoFactory.getGroupDao(connection);
            list = groups.getAll();
        }
        
        for (Group group:list) {
            System.out.print(group.getName() + " ");
        }
        System.out.println();
        
//        System.out.println("---Список всех аудиторий университета---");
//        List<Classroom> classrooms = new ClassroomDao().getAllClassrooms();
//        for (Classroom classroom : classrooms) {
//            System.out.print(classroom.getName() + ", ");
//        }
//        System.out.print(" - всего " + classrooms.size() + "\n");
//        System.out.println();
//
//        System.out.println("---Список всех предметов, изучаемых в университете---");
//        List<Subject> subjects = new SubjectDao().getAllSubjects();
//        for (Subject subject : subjects) {
//            System.out.println(subject.getName());
//        }
//        System.out.print(" - всего " + subjects.size() + "\n");
//        System.out.println();
//
//        System.out.println("---Преподавательский состав университета---");
//        List<Teacher> teachers = new TeacherDao().getAllTeachers();
//        for (Teacher teacher : teachers) {
//            System.out.println(teacher.getId() + ") " + teacher.getLastName() + " " + teacher.getFirstName() + " "
//                    + teacher.getMiddleName());
//        }
//        System.out.println();
//
//        System.out.println("---Список всех учаащихся в университете---");
//        List<Student> students = new StudentDaoClass().getAllStudents();
//        for (Student student : students) {
//            System.out.println(student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName()
//                    + " ( id = " + student.getId() + " )");
//        }
//        System.out.println();
    }



    private static void createUniversitySchedule() {

        Lecture lecture1 = itmo.createLecture("ИНФОКОММУНИКАЦИОННЫЕ СИСТЕМЫ И ТЕХНОЛОГИИ", 1, "K-3120", "466");
        Lecture lecture2 = itmo.createLecture("ИНФОКОММУНИКАЦИОННЫЕ СИСТЕМЫ И ТЕХНОЛОГИИ", 1, "M-3100", "466");
        Lecture lecture3 = itmo.createLecture("ИНФОКОММУНИКАЦИОННЫЕ СИСТЕМЫ И ТЕХНОЛОГИИ", 1, "N-3147", "466");
        Lecture lecture4 = itmo.createLecture("ПРОГРАММИРОВАНИЕ", 2, "K-3120", "151");
        Lecture lecture5 = itmo.createLecture("ПРОГРАММИРОВАНИЕ", 2, "M-3100", "151");
        Lecture lecture6 = itmo.createLecture("ПРОГРАММИРОВАНИЕ", 2, "N-3147", "151");
        Lecture lecture7 = itmo.createLecture("АНГЛИЙСКИЙ ЯЗЫК", 3, "K-3120", "100/1");
        Lecture lecture8 = itmo.createLecture("АНГЛИЙСКИЙ ЯЗЫК", 3, "M-3100", "100/1");
        Lecture lecture9 = itmo.createLecture("АНГЛИЙСКИЙ ЯЗЫК", 3, "N-3147", "100/1");
        Lecture lecture10 = itmo.createLecture("МАТЕМАТИКА", 4, "K-3120", "190");
        Lecture lecture11 = itmo.createLecture("МАТЕМАТИКА", 4, "M-3100", "190");
        Lecture lecture12 = itmo.createLecture("МАТЕМАТИКА", 4, "N-3147", "190");
        Lecture lecture13 = itmo.createLecture("ИСТОРИЯ", 5, "K-3120", "466");
        Lecture lecture14 = itmo.createLecture("ИСТОРИЯ", 5, "M-3100", "466");
        Lecture lecture15 = itmo.createLecture("ИСТОРИЯ", 5, "N-3147", "466");
        Lecture lecture16 = itmo.createLecture("КОМПЬЮТЕРНАЯ ИНЖЕНЕРНАЯ ГРАФИКА", 6, "K-3120", "151");
        Lecture lecture17 = itmo.createLecture("КОМПЬЮТЕРНАЯ ИНЖЕНЕРНАЯ ГРАФИКА", 6, "M-3100", "151");
        Lecture lecture18 = itmo.createLecture("КОМПЬЮТЕРНАЯ ИНЖЕНЕРНАЯ ГРАФИКА", 6, "N-3147", "151");
        Lecture lecture19 = itmo.createLecture("ИНФОРМАТИКА", 7, "K-3120", "331");
        Lecture lecture20 = itmo.createLecture("ИНФОРМАТИКА", 7, "M-3100", "331");
        Lecture lecture21 = itmo.createLecture("ИНФОРМАТИКА", 7, "N-3147", "331");
        Lecture lecture22 = itmo.createLecture("ВВЕДЕНИЕ В ЦИФРОВУЮ КУЛЬТУРУ", 8, "K-3120", "2503");
        Lecture lecture23 = itmo.createLecture("ВВЕДЕНИЕ В ЦИФРОВУЮ КУЛЬТУРУ", 8, "M-3100", "2503");
        Lecture lecture24 = itmo.createLecture("ВВЕДЕНИЕ В ЦИФРОВУЮ КУЛЬТУРУ", 8, "N-3147", "2503");
        Lecture lecture25 = itmo.createLecture("АРХИТЕКТУРА ЭВМ", 9, "K-3120", "190");
        Lecture lecture26 = itmo.createLecture("АРХИТЕКТУРА ЭВМ", 9, "M-3100", "190");
        Lecture lecture27 = itmo.createLecture("АРХИТЕКТУРА ЭВМ", 9, "N-3147", "190");
        Lecture lecture28 = itmo.createLecture("АЛГОРИТМЫ И СТРУКТУРЫ ДАННЫХ", 10, "K-3120", "2504");
        Lecture lecture29 = itmo.createLecture("АЛГОРИТМЫ И СТРУКТУРЫ ДАННЫХ", 10, "M-3100", "2504");
        Lecture lecture30 = itmo.createLecture("АЛГОРИТМЫ И СТРУКТУРЫ ДАННЫХ", 10, "N-3147", "2504");
        Lecture lecture31 = itmo.createLecture("ЛИНЕЙНАЯ АЛГЕБРА", 11, "K-3120", "2504");
        Lecture lecture32 = itmo.createLecture("ЛИНЕЙНАЯ АЛГЕБРА", 11, "M-3100", "2504");
        Lecture lecture33 = itmo.createLecture("ЛИНЕЙНАЯ АЛГЕБРА", 11, "N-3147", "2504");
        Lecture lecture34 = itmo.createLecture("ФИЗИКА", 12, "K-3120", "99");
        Lecture lecture35 = itmo.createLecture("ФИЗИКА", 12, "M-3100", "99");
        Lecture lecture36 = itmo.createLecture("ФИЗИКА", 12, "N-3147", "99");
        Lecture lecture37 = itmo.createLecture("ВВЕДЕНИЕ В ПРОФЕССИОНАЛЬНУЮ ДЕЯТЕЛЬНОСТЬ", 13, "K-3120", "101");
        Lecture lecture38 = itmo.createLecture("ВВЕДЕНИЕ В ПРОФЕССИОНАЛЬНУЮ ДЕЯТЕЛЬНОСТЬ", 13, "M-3100", "101");
        Lecture lecture39 = itmo.createLecture("ВВЕДЕНИЕ В ПРОФЕССИОНАЛЬНУЮ ДЕЯТЕЛЬНОСТЬ", 13, "N-3147", "101");
        Lecture lecture40 = itmo.createLecture("ВВЕДЕНИЕ В ЦИФРОВУЮ КУЛЬТУРУ", 14, "K-3120", "101");
        Lecture lecture41 = itmo.createLecture("ВВЕДЕНИЕ В ЦИФРОВУЮ КУЛЬТУРУ", 14, "M-3100", "101");
        Lecture lecture42 = itmo.createLecture("ВВЕДЕНИЕ В ЦИФРОВУЮ КУЛЬТУРУ", 14, "N-3147", "101");
        Lecture lecture43 = itmo.createLecture("ЛИНЕЙНАЯ АЛГЕБРА", 15, "K-3120", "151");
        Lecture lecture44 = itmo.createLecture("ЛИНЕЙНАЯ АЛГЕБРА", 15, "M-3100", "151");
        Lecture lecture45 = itmo.createLecture("ЛИНЕЙНАЯ АЛГЕБРА", 15, "N-3147", "151");
        Lecture lecture46 = itmo.createLecture("ДИСКРЕТНАЯ МАТЕМАТИКА", 16, "K-3120", "2503");
        Lecture lecture47 = itmo.createLecture("ДИСКРЕТНАЯ МАТЕМАТИКА", 16, "M-3100", "2503");
        Lecture lecture48 = itmo.createLecture("ДИСКРЕТНАЯ МАТЕМАТИКА", 16, "N-3147", "2503");

        Set<Lecture> lesson1 = new HashSet<>();
        lesson1.add(lecture1);
        lesson1.add(lecture5);
        lesson1.add(lecture9);
        Set<Lecture> lesson2 = new HashSet<>();
        lesson2.add(lecture13);
        lesson2.add(lecture17);
        lesson2.add(lecture21);
        Set<Lecture> lesson3 = new HashSet<>();
        lesson3.add(lecture19);
        lesson3.add(lecture23);
        lesson3.add(lecture27);
        Set<Lecture> lesson4 = new HashSet<>();
        lesson4.add(lecture10);
        lesson4.add(lecture14);
        lesson4.add(lecture18);
        Set<Lecture> lesson5 = new HashSet<>();
        lesson5.add(lecture16);
        lesson5.add(lecture20);
        lesson5.add(lecture24);
        Set<Lecture> lesson6 = new HashSet<>();
        lesson6.add(lecture7);
        lesson6.add(lecture11);
        lesson6.add(lecture15);
        Set<Lecture> lesson7 = new HashSet<>();
        lesson7.add(lecture31);
        lesson7.add(lecture35);
        lesson7.add(lecture39);
        Set<Lecture> lesson8 = new HashSet<>();
        lesson8.add(lecture43);
        lesson8.add(lecture47);
        lesson8.add(lecture3);
        Set<Lecture> lesson9 = new HashSet<>();
        lesson9.add(lecture25);
        lesson9.add(lecture29);
        lesson9.add(lecture33);
        Set<Lecture> lesson10 = new HashSet<>();
        lesson10.add(lecture4);
        lesson10.add(lecture8);
        lesson10.add(lecture12);
        Set<Lecture> lesson11 = new HashSet<>();
        lesson11.add(lecture28);
        lesson11.add(lecture32);
        lesson11.add(lecture36);
        Set<Lecture> lesson12 = new HashSet<>();
        lesson12.add(lecture22);
        lesson12.add(lecture26);
        lesson12.add(lecture30);
        Set<Lecture> lesson13 = new HashSet<>();
        lesson13.add(lecture34);
        lesson13.add(lecture38);
        lesson13.add(lecture42);
        Set<Lecture> lesson14 = new HashSet<>();
        lesson14.add(lecture19);
        lesson14.add(lecture23);
        lesson14.add(lecture27);
        Set<Lecture> lesson15 = new HashSet<>();
        lesson15.add(lecture40);
        lesson15.add(lecture44);
        lesson15.add(lecture48);
        Set<Lecture> lesson16 = new HashSet<>();
        lesson16.add(lecture46);
        lesson16.add(lecture2);
        lesson16.add(lecture6);
        Set<Lecture> lesson17 = new HashSet<>();
        lesson17.add(lecture10);
        lesson17.add(lecture14);
        lesson17.add(lecture18);
        Set<Lecture> lesson18 = new HashSet<>();
        lesson18.add(lecture37);
        lesson18.add(lecture41);
        lesson18.add(lecture45);
        Set<Lecture> lesson19 = new HashSet<>();
        lesson19.add(lecture7);
        lesson19.add(lecture5);
        lesson19.add(lecture3);
        Set<Lecture> lesson20 = new HashSet<>();
        lesson20.add(lecture7);
        lesson20.add(lecture23);
        lesson20.add(lecture21);
        Set<Lecture> lesson21 = new HashSet<>();
        lesson21.add(lecture34);
        lesson21.add(lecture32);
        lesson21.add(lecture30);
        Set<Lecture> lesson22 = new HashSet<>();
        lesson22.add(lecture13);
        lesson22.add(lecture11);
        lesson22.add(lecture9);
        Set<Lecture> lesson23 = new HashSet<>();
        lesson23.add(lecture10);
        lesson23.add(lecture8);
        lesson23.add(lecture6);
        Set<Lecture> lesson24 = new HashSet<>();
        lesson24.add(lecture28);
        lesson24.add(lecture17);
        lesson24.add(lecture6);
        Set<Lecture> lesson25 = new HashSet<>();
        lesson25.add(lecture1);
        lesson25.add(lecture17);
        lesson25.add(lecture9);
        Set<Lecture> lesson26 = new HashSet<>();
        lesson26.add(lecture34);
        lesson26.add(lecture29);
        lesson26.add(lecture24);
        Set<Lecture> lesson27 = new HashSet<>();
        lesson27.add(lecture10);
        lesson27.add(lecture20);
        lesson27.add(lecture30);

        Map<Lesson, Set<Lecture>> oddMon = new HashMap<>();
        oddMon.put(Lesson.FIRST, lesson1);
        oddMon.put(Lesson.SECOND, lesson1);
        oddMon.put(Lesson.THIRD, lesson2);
        oddMon.put(Lesson.FOURTH, lesson3);
        oddMon.put(Lesson.FIFTH, lesson4);
        Map<Lesson, Set<Lecture>> oddTue = new HashMap<>();
        oddTue.put(Lesson.FIRST, lesson5);
        oddTue.put(Lesson.SECOND, lesson5);
        oddTue.put(Lesson.THIRD, lesson6);
        oddTue.put(Lesson.FOURTH, lesson6);
        oddTue.put(Lesson.FIFTH, lesson7);
        Map<Lesson, Set<Lecture>> oddWen = new HashMap<>();
        oddWen.put(Lesson.FIRST, lesson8);
        oddWen.put(Lesson.SECOND, lesson9);
        oddWen.put(Lesson.THIRD, lesson10);
        oddWen.put(Lesson.FOURTH, lesson10);
        oddWen.put(Lesson.FIFTH, lesson11);
        Map<Lesson, Set<Lecture>> oddThu = new HashMap<>();
        oddThu.put(Lesson.FIRST, lesson7);
        oddThu.put(Lesson.SECOND, lesson12);
        oddThu.put(Lesson.THIRD, lesson12);
        oddThu.put(Lesson.FOURTH, lesson13);
        oddThu.put(Lesson.FIFTH, lesson14);
        Map<Lesson, Set<Lecture>> oddFri = new HashMap<>();
        oddFri.put(Lesson.FIRST, lesson8);
        oddFri.put(Lesson.SECOND, lesson13);
        oddFri.put(Lesson.THIRD, lesson15);
        oddFri.put(Lesson.FOURTH, lesson16);
        oddFri.put(Lesson.FIFTH, lesson17);
        Map<Lesson, Set<Lecture>> oddSat = new HashMap<>();
        oddSat.put(Lesson.FIRST, lesson10);
        oddSat.put(Lesson.SECOND, lesson18);
        oddSat.put(Lesson.THIRD, lesson18);

        Map<Lesson, Set<Lecture>> evenMon = new HashMap<>();
        evenMon.put(Lesson.FIRST, lesson1);
        evenMon.put(Lesson.SECOND, lesson19);
        evenMon.put(Lesson.THIRD, lesson20);
        evenMon.put(Lesson.FOURTH, lesson2);
        evenMon.put(Lesson.FIFTH, lesson21);
        evenMon.put(Lesson.SIXTH, lesson21);
        Map<Lesson, Set<Lecture>> evenTue = new HashMap<>();
        evenTue.put(Lesson.FIRST, lesson22);
        evenTue.put(Lesson.SECOND, lesson5);
        evenTue.put(Lesson.THIRD, lesson6);
        evenTue.put(Lesson.FOURTH, lesson6);
        evenTue.put(Lesson.FIFTH, lesson7);
        Map<Lesson, Set<Lecture>> evenWen = new HashMap<>();
        evenWen.put(Lesson.FIRST, lesson8);
        evenWen.put(Lesson.SECOND, lesson9);
        evenWen.put(Lesson.THIRD, lesson23);
        evenWen.put(Lesson.FOURTH, lesson23);
        evenWen.put(Lesson.FIFTH, lesson11);
        Map<Lesson, Set<Lecture>> evenThu = new HashMap<>();
        evenThu.put(Lesson.FIRST, lesson7);
        evenThu.put(Lesson.SECOND, lesson12);
        evenThu.put(Lesson.THIRD, lesson12);
        evenThu.put(Lesson.FOURTH, lesson13);
        evenThu.put(Lesson.FIFTH, lesson14);
        Map<Lesson, Set<Lecture>> evenFri = new HashMap<>();
        evenFri.put(Lesson.FIRST, lesson24);
        evenFri.put(Lesson.SECOND, lesson13);
        evenFri.put(Lesson.THIRD, lesson25);
        evenFri.put(Lesson.FOURTH, lesson16);
        evenFri.put(Lesson.FIFTH, lesson26);
        Map<Lesson, Set<Lecture>> evenSat = new HashMap<>();
        evenSat.put(Lesson.FIRST, lesson27);
        evenSat.put(Lesson.SECOND, lesson18);
        evenSat.put(Lesson.THIRD, lesson18);

        Map<Parity, Map<Lesson, Set<Lecture>>> monday = new HashMap<>();
        monday.put(Parity.ODD, oddMon);
        monday.put(Parity.EVEN, evenMon);
        Map<Parity, Map<Lesson, Set<Lecture>>> tuesday = new HashMap<>();
        tuesday.put(Parity.ODD, oddTue);
        tuesday.put(Parity.EVEN, evenTue);
        Map<Parity, Map<Lesson, Set<Lecture>>> wednesday = new HashMap<>();
        wednesday.put(Parity.ODD, oddWen);
        wednesday.put(Parity.EVEN, evenWen);
        Map<Parity, Map<Lesson, Set<Lecture>>> thursday = new HashMap<>();
        thursday.put(Parity.ODD, oddThu);
        thursday.put(Parity.EVEN, evenThu);
        Map<Parity, Map<Lesson, Set<Lecture>>> friday = new HashMap<>();
        friday.put(Parity.ODD, oddFri);
        friday.put(Parity.EVEN, evenFri);
        Map<Parity, Map<Lesson, Set<Lecture>>> saturday = new HashMap<>();
        saturday.put(Parity.ODD, oddSat);
        saturday.put(Parity.EVEN, evenSat);

        itmo.setSchedule(new Schedule());
        itmo.getSchedule().addScheduleForDay(DayOfWeek.MONDAY, monday);
        itmo.getSchedule().addScheduleForDay(DayOfWeek.TUESDAY, tuesday);
        itmo.getSchedule().addScheduleForDay(DayOfWeek.WEDNESDAY, wednesday);
        itmo.getSchedule().addScheduleForDay(DayOfWeek.THURSDAY, thursday);
        itmo.getSchedule().addScheduleForDay(DayOfWeek.FRIDAY, friday);
        itmo.getSchedule().addScheduleForDay(DayOfWeek.SATURDAY, saturday);

    }

    private static void showUniversitySchedule() {

        for (Parity parity : Parity.values()) {
            for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
                for (Map.Entry<DayOfWeek, Map<Parity, Map<Lesson, Set<Lecture>>>> daySchedule : itmo.getSchedule()
                        .getSchedule().entrySet()) {
                    if (daySchedule.getKey() == dayOfWeek) {
                        System.out.print(dayOfWeek + " ");
                        for (Map.Entry<Parity, Map<Lesson, Set<Lecture>>> dayParity : daySchedule.getValue()
                                .entrySet()) {
                            if (dayParity.getKey() == parity) {
                                System.out.println(dayParity.getKey() + " ");
                                System.out.println("------------------");
                                for (Lesson les : Lesson.values()) {
                                    for (Map.Entry<Lesson, Set<Lecture>> lessons : dayParity.getValue().entrySet()) {
                                        if (lessons.getKey() == les) {
                                            System.out.println("  - " + lessons.getKey().getDescription() + ": ");
                                            for (Lecture lec : lessons.getValue()) {
                                                System.out.print(lec.getSubject().getName() + " ("
                                                        + lec.getTeacher().getLastName() + ") "
                                                        + lec.getGroup().getName() + " " + lec.getClassroom().getName()
                                                        + " | ");
                                            }
                                            System.out.println();
                                        }
                                    }
                                }
                                System.out.println();
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    private static void showStudentSchedule() {
        int studentId = 13;
        Student student = itmo.getStudentById(studentId);
        System.out.println("Расписание на месяц для: " + student.getLastName() + " " + student.getFirstName() + " "
                + student.getMiddleName() + "\nгруппа " + student.getGroup().getName());
        System.out.println();

        Map<DayOfWeek, Map<Parity, Map<Lesson, Set<Lecture>>>> studentSchedule = itmo.getSchedule()
                .showStudentSchedule(student);

        for (Parity parity : Parity.values()) {
            for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
                for (Map.Entry<DayOfWeek, Map<Parity, Map<Lesson, Set<Lecture>>>> daySchedule : studentSchedule
                        .entrySet()) {
                    if (daySchedule.getKey() == dayOfWeek) {
                        System.out.print(dayOfWeek + " ");
                        for (Map.Entry<Parity, Map<Lesson, Set<Lecture>>> dayParity : daySchedule.getValue()
                                .entrySet()) {
                            if (dayParity.getKey() == parity) {
                                System.out.println(dayParity.getKey() + " ");
                                System.out.println("------------------");
                                for (Lesson les : Lesson.values()) {
                                    for (Map.Entry<Lesson, Set<Lecture>> lessons : dayParity.getValue().entrySet()) {
                                        if (lessons.getKey() == les) {
                                            System.out.print("  - " + lessons.getKey().getDescription() + ": ");
                                            for (Lecture lec : lessons.getValue()) {
                                                System.out.println(lec.getSubject().getName() + " ("
                                                        + lec.getTeacher().getLastName() + ") "
                                                        + lec.getGroup().getName() + " "
                                                        + lec.getClassroom().getName());
                                            }
                                            System.out.println();
                                        }
                                    }
                                }
                                System.out.println();
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    private static void showTeacherSchedule() {
        int teacherId = 9;
        Teacher teacher = itmo.getTeacherById(teacherId);
        System.out.println("______________________________");
        System.out.println("Расписание на месяц для преподавателя: " + teacher.getLastName() + " "
                + teacher.getFirstName() + " " + teacher.getMiddleName() + "\n");

        Map<DayOfWeek, Map<Parity, Map<Lesson, Set<Lecture>>>> teacherSchedule = itmo.getSchedule()
                .showTeacherSchedule(teacher);

        for (Parity parity : Parity.values()) {
            for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
                for (Map.Entry<DayOfWeek, Map<Parity, Map<Lesson, Set<Lecture>>>> daySchedule : teacherSchedule
                        .entrySet()) {
                    if (daySchedule.getKey() == dayOfWeek) {
                        System.out.print(dayOfWeek + " ");
                        for (Map.Entry<Parity, Map<Lesson, Set<Lecture>>> dayParity : daySchedule.getValue()
                                .entrySet()) {
                            if (dayParity.getKey() == parity) {
                                System.out.println(dayParity.getKey() + " ");
                                System.out.println("------------------");
                                for (Lesson les : Lesson.values()) {
                                    for (Map.Entry<Lesson, Set<Lecture>> lessons : dayParity.getValue().entrySet()) {
                                        if (lessons.getKey() == les) {
                                            System.out.print("  - " + lessons.getKey().getDescription() + ": ");
                                            for (Lecture lec : lessons.getValue()) {
                                                System.out.print(lec.getSubject().getName() + " ("
                                                        + lec.getTeacher().getLastName() + ") "
                                                        + lec.getGroup().getName() + " "
                                                        + lec.getClassroom().getName());
                                            }
                                            System.out.println();
                                        }
                                    }
                                }
                                System.out.println();
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    private static void showStudentScheduleForDay() {
        int studentId = 7;
        LocalDate date = LocalDate.of(2018, 10, 22); // понедельник чет

        Student student = itmo.getStudentById(studentId);

        System.out.println("______________________________");
        System.out.println("Расписание на: " + date + " \nдля студента: " + student.getLastName() + " "
                + student.getFirstName() + " " + student.getMiddleName() + "\nгруппа: " + student.getGroup().getName());
        System.out.println("______________________________");

        Map<DayOfWeek, Map<Parity, Map<Lesson, Set<Lecture>>>> studentSchedule = itmo.getSchedule()
                .showStudentDaySchedule(student, date);

        for (Parity parity : Parity.values()) {
            for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
                for (Map.Entry<DayOfWeek, Map<Parity, Map<Lesson, Set<Lecture>>>> daySchedule : studentSchedule
                        .entrySet()) {
                    if (daySchedule.getKey() == dayOfWeek) {
                        System.out.print(dayOfWeek + " ");
                        for (Map.Entry<Parity, Map<Lesson, Set<Lecture>>> dayParity : daySchedule.getValue()
                                .entrySet()) {
                            if (dayParity.getKey() == parity) {
                                System.out.println(dayParity.getKey() + " ");
                                System.out.println("------------------");
                                for (Lesson les : Lesson.values()) {
                                    for (Map.Entry<Lesson, Set<Lecture>> lessons : dayParity.getValue().entrySet()) {
                                        if (lessons.getKey() == les) {
                                            System.out.print("  - " + lessons.getKey().getDescription() + ": ");
                                            for (Lecture lec : lessons.getValue()) {
                                                System.out.println(lec.getSubject().getName() + " ("
                                                        + lec.getTeacher().getLastName() + ") "
                                                        + lec.getGroup().getName() + " "
                                                        + lec.getClassroom().getName());
                                            }
                                            System.out.println();
                                        }
                                    }
                                }
                                System.out.println();
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    private static void showTeacherScheduleForDay() {
        int teacherId = 9;
        LocalDate date = LocalDate.of(2018, 10, 29);

        Teacher teacher = itmo.getTeacherById(teacherId);

        System.out.println();
        System.out.println("______________________________");
        System.out.println("Расписание на " + date + "\nдля преподавателя: " + teacher.getLastName() + " "
                + teacher.getFirstName() + " " + teacher.getMiddleName());
        System.out.println("______________________________");

        Map<DayOfWeek, Map<Parity, Map<Lesson, Set<Lecture>>>> teacherSchedule = itmo.getSchedule()
                .showTeacherDaySchedule(teacher, date);

        for (Parity parity : Parity.values()) {
            for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
                for (Map.Entry<DayOfWeek, Map<Parity, Map<Lesson, Set<Lecture>>>> daySchedule : teacherSchedule
                        .entrySet()) {
                    if (daySchedule.getKey() == dayOfWeek) {
                        System.out.print(dayOfWeek + " ");
                        for (Map.Entry<Parity, Map<Lesson, Set<Lecture>>> dayParity : daySchedule.getValue()
                                .entrySet()) {
                            if (dayParity.getKey() == parity) {
                                System.out.println(dayParity.getKey() + " ");
                                System.out.println("------------------");
                                for (Lesson les : Lesson.values()) {
                                    for (Map.Entry<Lesson, Set<Lecture>> lessons : dayParity.getValue().entrySet()) {
                                        if (lessons.getKey() == les) {
                                            System.out.print("  - " + lessons.getKey().getDescription() + ": ");
                                            for (Lecture lec : lessons.getValue()) {
                                                System.out.print(lec.getSubject().getName() + " ("
                                                        + lec.getTeacher().getLastName() + ") "
                                                        + lec.getGroup().getName() + " "
                                                        + lec.getClassroom().getName());
                                            }
                                            System.out.println();
                                        }
                                    }
                                }
                                System.out.println();
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
