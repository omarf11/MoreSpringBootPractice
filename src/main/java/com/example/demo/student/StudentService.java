package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    // for mongo db repository integration -- you dont need JPA if u use mongodb
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();

    }

    public void addnewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        } else
            studentRepository.save(student);
    }

    public void deleteStudent(String id) {

        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new IllegalStateException("User does not exist!");
        }

        // Optional<Student> studentOptional = studentRepository.findStudentById(id);

        // if (studentOptional.isEmpty()) {
        // throw new IllegalStateException("User does not exist");
        // } else
        // studentRepository.deleteStudentById(id);
    }

}

// List.of(
// new Student(
// 1L,
// "dave",
// "dave@gmail.com",
// LocalDate.of(1998, Month.OCTOBER, 22),
// 23));