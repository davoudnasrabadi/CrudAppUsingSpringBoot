/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.student.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author davoudnasrabadi
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    
    @Query("SELECT s FROM Student s WHERE s.email= ?1")
    Optional<Student> findStudentByEmail(String email);
}
