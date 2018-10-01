package com.valunskii.foxminded.university.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniverstiyStart {

    private static University itmo;

    public static void main(String[] args) {
        createUniversity();
        showCreatedUniversity();

        createUniversitySchedule();
        showUniversitySchedule();
        showStudentSchedule();
        showTeacherSchedule();
        showStudentScheduleForDay();
        showTeacherScheduleForDay();
    }

    private static void showCreatedUniversity() {
        System.out.println("---Список всех аудиторий университета---");
        for (Classroom classroom : itmo.getClassrooms()) {
            System.out.println(classroom.getName());
        }
        System.out.println();
        System.out.println("---Список всех предметов, изучаемых в университете---");
        for (Subject subject : itmo.getSubjects()) {
            System.out.println(subject.getName());
        }
        System.out.println();
        System.out.println("---Преподавательский состав университета---");
        for (Teacher teacher : itmo.getTeachers()) {
            System.out.println(teacher.getLastName() + " " + teacher.getFirstName() + " " + teacher.getMiddleName());
        }
        System.out.println();

        System.out.println("---Список всех групп университета и их студентов---");
        for (Group group : itmo.getGroups()) {
            System.out.println("        группа " + group.getName() + ":");
            System.out.println("--------------------------------");
            for (Student student : group.getStudents()) {
                System.out.println(student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName()
                        + " ( id = " + student.getId() + " )");
            }
            System.out.println();
        }
    }

    private static void createUniversity() {
        itmo = new University();

        Classroom classroom466 = new Classroom("466");
        Classroom classroom331 = new Classroom("331");
        Classroom classroom100s1 = new Classroom("100/1");
        Classroom classroom190 = new Classroom("190");
        Classroom classroom151 = new Classroom("151");
        Classroom classroom2503 = new Classroom("2503");
        Classroom classroom2504 = new Classroom("2504");
        Classroom classroom99 = new Classroom("99");
        Classroom classroom101 = new Classroom("101");
        itmo.addClassroom(classroom466);
        itmo.addClassroom(classroom331);
        itmo.addClassroom(classroom100s1);
        itmo.addClassroom(classroom190);
        itmo.addClassroom(classroom151);
        itmo.addClassroom(classroom2503);
        itmo.addClassroom(classroom2504);
        itmo.addClassroom(classroom99);
        itmo.addClassroom(classroom101);

        Subject infocomunicatSystemsTechnologies = new Subject("ИНФОКОММУНИКАЦИОННЫЕ СИСТЕМЫ И ТЕХНОЛОГИИ");
        Subject programming = new Subject("ПРОГРАММИРОВАНИЕ");
        Subject english = new Subject("АНГЛИЙСКИЙ ЯЗЫК");
        Subject math = new Subject("МАТЕМАТИКА");
        Subject history = new Subject("ИСТОРИЯ");
        Subject computerEngineeringGraphics = new Subject("КОМПЬЮТЕРНАЯ ИНЖЕНЕРНАЯ ГРАФИКА");
        Subject informatics = new Subject("ИНФОРМАТИКА");
        Subject introductionDigitalCulture = new Subject("ВВЕДЕНИЕ В ЦИФРОВУЮ КУЛЬТУРУ");
        Subject compArchitecture = new Subject("АРХИТЕКТУРА ЭВМ");
        Subject algorithms = new Subject("АЛГОРИТМЫ И СТРУКТУРЫ ДАННЫХ");
        Subject linearAlgebra = new Subject("ЛИНЕЙНАЯ АЛГЕБРА");
        Subject discreteMath = new Subject("ДИСКРЕТНАЯ МАТЕМАТИКА");
        Subject mathematicalAnalysis = new Subject("МАТЕМАТИЧЕСКИЙ АНАЛИЗ");
        Subject physics = new Subject("ФИЗИКА");
        Subject introductionProfessionalActivity = new Subject("ВВЕДЕНИЕ В ПРОФЕССИОНАЛЬНУЮ ДЕЯТЕЛЬНОСТЬ");
        itmo.addSubject(infocomunicatSystemsTechnologies);
        itmo.addSubject(programming);
        itmo.addSubject(english);
        itmo.addSubject(math);
        itmo.addSubject(history);
        itmo.addSubject(computerEngineeringGraphics);
        itmo.addSubject(informatics);
        itmo.addSubject(introductionDigitalCulture);
        itmo.addSubject(compArchitecture);
        itmo.addSubject(algorithms);
        itmo.addSubject(linearAlgebra);
        itmo.addSubject(discreteMath);
        itmo.addSubject(mathematicalAnalysis);
        itmo.addSubject(physics);
        itmo.addSubject(introductionProfessionalActivity);

        Teacher teacher1 = new Teacher(1, "Светлана", "Валерьевна", "Одиночкина"); // 1 ИНФОКОММУНИКАЦИОННЫЕ СИСТЕМЫ И
                                                                                   // ТЕХНОЛОГИИ
        Teacher teacher2 = new Teacher(2, "Елена", "Вадимовна", "Павлычева"); // 2 ПРОГРАММИРОВАНИЕ
        Teacher teacher3 = new Teacher(3, "Семен", "Алексеевич", "Петухов"); // 3 АНГЛИЙСКИЙ ЯЗЫК @
        Teacher teacher4 = new Teacher(4, "Юлия", "Валерьевна", "Танченко"); // 4 МАТЕМАТИКА
        Teacher teacher5 = new Teacher(5, "Владимир", "Юрьевич", "Лукьянов"); // 5 ИСТОРИЯ
        Teacher teacher6 = new Teacher(6, "Антон", "Сергеевич", "Супрун"); // 6 КОМПЬЮТЕРНАЯ ИНЖЕНЕРНАЯ ГРАФИКА
        Teacher teacher7 = new Teacher(7, "Андрей", "Владимирович", "Лямин"); // 7 ИНФОРМАТИКА
        Teacher teacher8 = new Teacher(8, "Наталья", "Генриховна", "Графеева"); // 8 ВВЕДЕНИЕ В ЦИФРОВУЮ КУЛЬТУРУ
        Teacher teacher9 = new Teacher(9, "Владислав", "Вячеславович", "Повышев"); // 9 АРХИТЕКТУРА ЭВМ
        Teacher teacher10 = new Teacher(10, "Нина", "Сергеевна", "Буланова"); // 10 АЛГОРИТМЫ И СТРУКТУРЫ ДАННЫХ
        Teacher teacher11 = new Teacher(11, "Татьяна", "Федоровна", "Панкратова"); // 11 ЛИНЕЙНАЯ АЛГЕБРА,
                                                                                   // МАТЕМАТИЧЕСКИЙ АНАЛИЗ
        Teacher teacher12 = new Teacher(12, "Андрей", "Федорович", "Костко"); // 12 ФИЗИКА
        Teacher teacher13 = new Teacher(13, "Данил", "Анатольевич", "Заколдаев"); // 13 ВВЕДЕНИЕ В ПРОФЕССИОНАЛЬНУЮ
                                                                                  // ДЕЯТЕЛЬНОСТЬ
        Teacher teacher14 = new Teacher(14, "Максим", "Валерьевич", "Хлопотов"); // 14 ВВЕДЕНИЕ В ЦИФРОВУЮ КУЛЬТУРУ
        Teacher teacher15 = new Teacher(15, "Киселев", "Алексей", "Алексеевич"); // 15 ЛИНЕЙНАЯ АЛГЕБРА
        Teacher teacher16 = new Teacher(16, "Антон", "Сергеевич", "Пермяков"); // 16 ДИСКРЕТНАЯ МАТЕМАТИКА
        itmo.addTeacher(teacher1);
        itmo.addTeacher(teacher2);
        itmo.addTeacher(teacher3);
        itmo.addTeacher(teacher4);
        itmo.addTeacher(teacher5);
        itmo.addTeacher(teacher6);
        itmo.addTeacher(teacher7);
        itmo.addTeacher(teacher8);
        itmo.addTeacher(teacher9);
        itmo.addTeacher(teacher10);
        itmo.addTeacher(teacher11);
        itmo.addTeacher(teacher12);
        itmo.addTeacher(teacher13);
        itmo.addTeacher(teacher14);
        itmo.addTeacher(teacher15);
        itmo.addTeacher(teacher16);

        Group k3120 = new Group("K-3120");
        Group m3100 = new Group("M-3100");
        Group n3147 = new Group("N-3147");
        itmo.addGroup(k3120);
        itmo.addGroup(m3100);
        itmo.addGroup(n3147);

        Student student1 = new Student(1, "Иван", "Иванович", "Иванов");
        Student student2 = new Student(2, "Петр", "Петрович", "Петров");
        Student student3 = new Student(3, "Арсений", "Александрович", "Алешин");
        Student student4 = new Student(4, "Григорий", "Романович", "Василевский");
        Student student5 = new Student(5, "Алексей", "Антонович", "Веселовский");
        Student student6 = new Student(6, "Анастасия", "Ивановна", "Вяликова");
        Student student7 = new Student(7, "Катерина", "Сергеевна", "Иванова");
        itmo.addStudent(student1);
        itmo.addStudent(student2);
        itmo.addStudent(student3);
        itmo.addStudent(student4);
        itmo.addStudent(student5);
        itmo.addStudent(student6);
        itmo.addStudent(student7);
        itmo.addStudentToGroup(student1, k3120);
        itmo.addStudentToGroup(student2, k3120);
        itmo.addStudentToGroup(student3, k3120);
        itmo.addStudentToGroup(student4, k3120);
        itmo.addStudentToGroup(student5, k3120);
        itmo.addStudentToGroup(student6, k3120);
        itmo.addStudentToGroup(student7, k3120);
        Student student8 = new Student(8, "Евгений", "Вадимович", "Ибрагимов");
        Student student9 = new Student(9, "Алексей", "Алексеевич", "Федоров");
        Student student10 = new Student(10, "Иван", "Петрович", "Иванов");
        Student student11 = new Student(11, "Алексей", "Дмитриевич", "Туляков");
        Student student12 = new Student(12, "Тамара", "Араратовна", "Мартирасян");
        Student student13 = new Student(13, "Маргарита", "Вадимовна", "Валунская");
        Student student14 = new Student(14, "Соня", "Кириловна", "Нохова");
        itmo.addStudent(student8);
        itmo.addStudent(student9);
        itmo.addStudent(student10);
        itmo.addStudent(student11);
        itmo.addStudent(student12);
        itmo.addStudent(student13);
        itmo.addStudent(student14);
        itmo.addStudentToGroup(student8, m3100);
        itmo.addStudentToGroup(student9, m3100);
        itmo.addStudentToGroup(student10, m3100);
        itmo.addStudentToGroup(student11, m3100);
        itmo.addStudentToGroup(student12, m3100);
        itmo.addStudentToGroup(student13, m3100);
        itmo.addStudentToGroup(student14, m3100);
        Student student15 = new Student(15, "Анатолий", "Иванович", "Лобзик");
        Student student16 = new Student(16, "Станислав", "Евгениевич", "Лацис");
        Student student17 = new Student(17, "Ольга", "Петрововна", "Иванова");
        Student student18 = new Student(18, "Семен", "Дмитриевич", "Краснов");
        Student student19 = new Student(19, "Леонид", "Кирилович", "Попугалов");
        Student student20 = new Student(20, "Антон", "Сергеевич", "Городецкий");
        Student student21 = new Student(21, "Галина", "Антоновна", "Гордая");
        itmo.addStudent(student15);
        itmo.addStudent(student16);
        itmo.addStudent(student17);
        itmo.addStudent(student18);
        itmo.addStudent(student19);
        itmo.addStudent(student20);
        itmo.addStudent(student21);
        itmo.addStudentToGroup(student15, n3147);
        itmo.addStudentToGroup(student16, n3147);
        itmo.addStudentToGroup(student17, n3147);
        itmo.addStudentToGroup(student18, n3147);
        itmo.addStudentToGroup(student19, n3147);
        itmo.addStudentToGroup(student20, n3147);
        itmo.addStudentToGroup(student21, n3147);
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
