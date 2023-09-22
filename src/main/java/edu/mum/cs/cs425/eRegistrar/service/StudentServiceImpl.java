package edu.mum.cs.cs425.eRegistrar.service;

import edu.mum.cs.cs425.eRegistrar.model.Student;
import edu.mum.cs.cs425.eRegistrar.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> listStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student editStudent(Student student) {
        Student existingStudent = studentRepository.findById(student.getStudentId()).orElse(null);
        if(existingStudent!=null){
            BeanUtils.copyProperties(student, existingStudent);
        }
        else {
            existingStudent=student;
        }
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(long Id) {
        studentRepository.deleteById(Id);
    }

    @Override
    public Student getStudent(long Id) {
        return studentRepository.findById(Id).orElse(null);
    }
}
