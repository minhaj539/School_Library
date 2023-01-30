package com.Student_Library.Student._Library.Services;

import com.Student_Library.Student._Library.Models.Card;
import com.Student_Library.Student._Library.Models.Student;
import com.Student_Library.Student._Library.Repositories.CardRepository;
import com.Student_Library.Student._Library.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    CardService cardService4;

    @Autowired
    CardRepository cardRepository;    //me

    @Autowired
    StudentRepository studentRepository4;

    public Student getDetailsByEmail(String email){


        Student student = studentRepository4.findByEmailId(email);


        return student;
    }

    public Student getDetailsById(int id){
        Student student = studentRepository4.findById(id).get();

        return student;
    }

    public void createStudent(Student student){
        Card newCard=cardService4.createAndReturn(student);
    }

    public void updateStudent(Student student){
        studentRepository4.updateStudentDetails(student);
    }

    public void deleteStudent(int id){

        cardService4.deactivateCard(id);
        studentRepository4.deleteCustom(id);
        //Delete student and deactivate corresponding card
    }
}
