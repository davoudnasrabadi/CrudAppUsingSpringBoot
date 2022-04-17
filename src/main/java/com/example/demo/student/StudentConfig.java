/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.example.demo.student.StudentRepository;
import org.springframework.context.annotation.Bean;
import com.example.demo.student.Student;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
/**
 *
 * @author davoudnasrabadi
 */

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args ->{
            Student reza=new Student(
   
               "reza@gmail.com",
               "reza",
               LocalDate.of(2000, Month.DECEMBER, 2)
            );
            
               Student omid=new Student(
               "omid@gmail.com",
               "omid",
               LocalDate.of(2001, Month.DECEMBER, 2)
            );
               
            repository.saveAll(List.of(reza, omid));
           
        };
    }
}
