package com.Student_Library.Student._Library.Services;

import com.Student_Library.Student._Library.Models.Author;
import com.Student_Library.Student._Library.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {


    @Autowired
    AuthorRepository authorRepository1;

    public void create(Author author){
        // Author author=
        authorRepository1.save(author);
    }
}
