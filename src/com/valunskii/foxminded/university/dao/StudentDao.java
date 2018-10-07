package com.valunskii.foxminded.university.dao;

import java.util.List;

import com.valunskii.foxminded.university.domain.Student;

public interface StudentDao {
    
    public Student create();

    public Student read(int id);

    public void update(Student group);

    public void delete(Student group);
    
    public List<Student> getAll();
}
