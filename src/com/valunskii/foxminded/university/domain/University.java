package com.valunskii.foxminded.university.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
public class University {
    private Set<Subject> subjects = new HashSet<>();
    private Set<Teacher> teachers = new HashSet<>();
    private Set<Group> groups = new HashSet<>();
    private Set<Student> students = new HashSet<>();
    private Set<Classroom> classrooms = new HashSet<>();
    private @Setter Schedule schedule;

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void addStudentToGroup(Student student, Group group) {
        if (!groups.contains(group)) {
            addGroup(group);
        }
        group.addStudent(student);
        student.setGroup(group);
    }

    public void removeStudentFromGroup(Student student) {
        Group group = student.getGroup();
        group.removeStudent(student);
        students.remove(student);

    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void removeGroup(Group group) {
        groups.remove(group);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public void addClassroom(Classroom classroom) {
        classrooms.add(classroom);
    }

    public void removeClassroom(Classroom classroom) {
        classrooms.remove(classroom);
    }

    public Lecture createLecture(String subjectName, int teacherId, String groupName, String roomName) {
        Subject subject = null; // TODO hmmm something seems to be wrong. some input validation is needed!
        Teacher teacher = null;
        Group group = null;
        Classroom classroom = null;

        for (Subject s : subjects) {
            if (subjectName.equals(s.getName())) {
                subject = s;
            }
        }
        for (Teacher t : teachers) {
            if (teacherId == t.getId()) {
                teacher = t;
            }
        }
        for (Group g : groups) {
            if (groupName.equals(g.getName())) {
                group = g;
            }
        }
        for (Classroom r : classrooms) {
            if (roomName.equals(r.getName())) {
                classroom = r;
            }
        }
        return new Lecture(subject, teacher, group, classroom);
    }

    public Lecture createNoLecture() {
        return new Lecture(null, null, null, null); // TODO something...
    }

    public Student getStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null; // TODO: null shoudn't have business value!!!
    }

    public Teacher getTeacherById(int id) {
        for (Teacher t : teachers) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null; // TODO: null shoudn't have business value!!!
    }
}
