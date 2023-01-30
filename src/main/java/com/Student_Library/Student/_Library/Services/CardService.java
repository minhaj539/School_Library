package com.Student_Library.Student._Library.Services;

import com.Student_Library.Student._Library.Models.Card;
import com.Student_Library.Student._Library.Models.CardStatus;
import com.Student_Library.Student._Library.Models.Student;
import com.Student_Library.Student._Library.Repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {


    @Autowired
    CardRepository cardRepository3;

    public Card createAndReturn(Student student){
        Card card = new Card();
        card.setStudent(student);
        student.setCard(card);
        cardRepository3.save(card);
        //link student with a new card
        return card;
    }

    public void deactivateCard(int student_id){

        cardRepository3.deactivateCard(student_id, CardStatus.DEACTIVATED.toString());
    }
}

