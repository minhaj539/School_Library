package com.Student_Library.Student._Library.Controller;

import com.Student_Library.Student._Library.Models.Book;
import com.Student_Library.Student._Library.Models.Genre;
import com.Student_Library.Student._Library.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/createBook")
    public ResponseEntity<String> createBook(@RequestBody() Book book){
        bookService.createBook(book);
        String res="Success";
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    //Write createBook API with required annotations


    //Add required annotations
    @GetMapping("getBooks")
    public ResponseEntity getBooks(@RequestParam(value = "genre", required = false) String genre,
                                   @RequestParam(value = "available", required = false, defaultValue = "false") boolean available,
                                   @RequestParam(value = "author", required = false) String author){

        List<Book> bookList = bookService.getBooks( genre, available, author); //find the elements of the list by yourself

        return new ResponseEntity<>(bookList, HttpStatus.OK);

    }
}
