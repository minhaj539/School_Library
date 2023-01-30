package com.Student_Library.Student._Library.Repositories;

import com.Student_Library.Student._Library.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    public Author findByName(String authorName);
}

