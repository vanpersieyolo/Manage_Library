package com.example.demo.controller;
import com.example.demo.model.dto.dtoRequest.BookRequest;
import com.example.demo.model.dto.dtoResponse.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.book.IBookService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class BookController {

    @Autowired
    IBookService iBookService;

    @GetMapping("/createBook")
    public String createBook(){
        return "jaa";
    }

    @PostMapping(value = "/createBook")
    public BookResponse createBook(@RequestBody BookRequest bookRequest){
       return iBookService.save(bookRequest);
    }



}
