package com.Student_Library.Student._Library.Repositories;

import com.Student_Library.Student._Library.Models.Student;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Modifying
    @Query("update Student s set s.emailId = :#{#std.emailId}, " +
        "s.name = :#{#std.name}, " +
        "s.age = :#{#std.age} ," +
        "s.country = :#{#std.country} " +
        "where s.id = :#{#std.id}")
    int updateStudentDetails(Student std);


    @Modifying
    @Query("delete from Student s where s.id =:id")
    void deleteCustom(int id);

    Student findByEmailId(String email);
}

