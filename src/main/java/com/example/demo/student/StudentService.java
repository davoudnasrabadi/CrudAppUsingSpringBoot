/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.student.Student;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.util.StringUtils;
/**
 *
 * @author davoudnasrabadi
 */
@Service
public class StudentService {
        private final StudentRepository studentRepository;
        
        @Autowired
        public StudentService(StudentRepository studentRepository){
            this.studentRepository = studentRepository;
        }
        public List<Student> getStudent(){
            return this.studentRepository.findAll();
        }
        
        public void addNewStudent(Student student){
           Optional<Student> studentByEmail = this.studentRepository.findStudentByEmail(student.getEmail());
           if(studentByEmail.isPresent()){ 
               throw new IllegalStateException("Email Taken");
           }
           studentRepository.save(student);
        }
        
        @Transactional()
        public void updateStudent(Long id, String name, String email){
            Student student = studentRepository.findById(id)
                    .orElseThrow(() -> new IllegalStateException(
                      "Student not found"
                    ));
            if(name != null && name.length()>0 && !Objects.equals(name, student.getName())){
                student.setName(name);
            }
            
             if(email != null && email.length()>0 && !Objects.equals(email, student.getEmail())){
                student.setEmail(email);
            }
            
        }
  
   
        public void deleteStudent(Long studentId){
            boolean ex= studentRepository.existsById(studentId);
            if(!ex){
                  throw new IllegalStateException("Not exist");
            }
            studentRepository.deleteById(studentId);
        }
}
