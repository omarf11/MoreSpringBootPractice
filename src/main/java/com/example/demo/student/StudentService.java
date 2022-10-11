package com.example.demo.student;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    
    // for mongo db repository integration -- you dont need JPA if u use mongo
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return  studentRepository.findAll();
        // List.of(
        //         new Student(
        //                 1L,
        //                 "dave",
        //                 "dave@gmail.com",
        //                 LocalDate.of(1998, Month.OCTOBER, 22),
        //                 23));
    }

    public void addnewStudent(Student student) {
        studentRepository.save(student);
    }
}
