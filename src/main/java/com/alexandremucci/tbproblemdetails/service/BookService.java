package com.alexandremucci.tbproblemdetails.service;

import com.alexandremucci.tbproblemdetails.exception.DuplicateException;
import com.alexandremucci.tbproblemdetails.record.Book;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  final List<Book> books = new ArrayList<>();

  public List<Book> createBook(Book book) {
    if (books.contains(book)) {
      throw new DuplicateException("This book is already registered");
    }

    books.add(book);
    return books;
  }

}
