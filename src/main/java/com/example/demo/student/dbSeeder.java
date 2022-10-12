package com.example.demo.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class dbSeeder implements CommandLineRunner{
    private final StudentRepository studentRepository;

    @Autowired
    public dbSeeder(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        
        Student first = new Student("s1", "Jim", "Jim@jim.com", 20) ;
        Student second = new Student("s2", "Joe", "Jjoi@jim.com", 52);
        Student third = new Student("s3", "Joan", "Joan@jim.com", 32);
        // delete all resorts if already exist

                studentRepository.deleteAll();

                // add resorts to database
                List<Student> students = Arrays.asList(first,second,third);
                this.studentRepository.saveAll(students);
    }
}
