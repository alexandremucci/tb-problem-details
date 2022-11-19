package com.alexandremucci.tbproblemdetails.controller;

import com.alexandremucci.tbproblemdetails.record.Book;
import com.alexandremucci.tbproblemdetails.service.BookService;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/book")
public class BookController {

  final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping("/")
  public HttpEntity<List<Book>> insertBook(@RequestBody Book book) {
    return ResponseEntity.ok(bookService.createBook(book));
  }

}
