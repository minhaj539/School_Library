package com.Student_Library.Student._Library.Repositories;
import com.Student_Library.Student._Library.Models.Card;
import javax.persistence.*;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card, Integer> {



    @Modifying
    @Transactional
    @Query(value = "update card c set c.card_status =:status where c.id in (select card_id from student s where s.id =:student_id)", nativeQuery = true)
    void deactivateCard(int student_id, String status);
}

