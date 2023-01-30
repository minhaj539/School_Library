package com.Student_Library.Student._Library.Services;

import com.Student_Library.Student._Library.Models.Book;
import com.Student_Library.Student._Library.Models.Genre;
import com.Student_Library.Student._Library.Repositories.AuthorRepository;
import com.Student_Library.Student._Library.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;

    @Autowired
    AuthorRepository authorRepository;

    public void createBook(Book book){

        bookRepository2.save(book);
    }

    public List<Book> getBooks(String genre, boolean available, String author){
     /*   if(author!=null&&genre!=null){
            return bookRepository2.findBooksByGenreAuthor(genre,author,available);
        }
        else if(genre!=null){
            return bookRepository2.findBooksByGenre(genre,available);
        }
        else if(author!=null){
            return bookRepository2.findBooksByAuthor(author,available);
        }
        else{
            return bookRepository2.findByAvailability(available);
        }

        //find the elements of the list by yourself

    }*/
     if(genre != null && author != null){
        return bookRepository2.findBooksByGenreAuthor(genre, author, available);
    }else if(genre != null){
        return bookRepository2.findBooksByGenre(genre, available);
    }else if(author != null){
        return bookRepository2.findBooksByAuthor(author, available);
    }else{
        return bookRepository2.findByAvailability(available);
    }
}
}

