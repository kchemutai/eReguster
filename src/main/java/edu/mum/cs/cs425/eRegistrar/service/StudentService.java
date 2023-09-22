package edu.mum.cs.cs425.eRegistrar.service;

import edu.mum.cs.cs425.eRegistrar.model.Student;

import java.util.List;

public interface StudentService {
    Student registerStudent(Student student);
    List<Student> listStudents();
    Student editStudent(Student student);
    void deleteStudent(long Id);
    Student getStudent(long Id);
}
