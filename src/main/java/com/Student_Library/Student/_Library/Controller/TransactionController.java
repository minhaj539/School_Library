package com.Student_Library.Student._Library.Controller;

import com.Student_Library.Student._Library.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    //Add required annotations
    @PostMapping("/issue_book")
    public ResponseEntity<String> issueBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{
        try{
            String tId=transactionService.issueBook(cardId,bookId);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("transaction completed", HttpStatus.ACCEPTED);
    }

    //Add required annotations
    @PostMapping("/return_book")
    public ResponseEntity<String> returnBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{

        transactionService.returnBook(cardId,bookId);

        return new ResponseEntity<>("transaction completed", HttpStatus.ACCEPTED);
    }
}
