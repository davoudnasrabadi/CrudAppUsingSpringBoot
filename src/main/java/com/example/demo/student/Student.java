/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author davoudnasrabadi
 */

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
      name="student_sequence",
      sequenceName="student_sequence",
      allocationSize=1      
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    @Transient
    private Integer age;
    private LocalDate dob;
    
    public Student(){
        
    }
    
    public Student(Long id,String email,String name,LocalDate dob){
        this.id = id;
        this.email=email;
        this.name= name;
        this.dob=dob;
    }
    
      public Student(String email,String name,LocalDate dob){
  
        this.email=email;
        this.name= name;
        this.dob=dob;
    }
      
    public Long getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public Integer getAge(){
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    
    public LocalDate getDob(){
        return this.dob;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name= name;
    }
    public void setEmail(String email){
        this.email= email;
    }
    
    public void setAge(Integer age){
        this.age= age;
    }
    
    @Override
    public String toString(){
        return "Student {"+
                "id="+id+
                ",name="+name+
                ", email="+email+
                ", dob="+dob+
                ", age="+age+'}';
    }
}
