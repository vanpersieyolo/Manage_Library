package service.book;

import com.example.demo.model.dto.dtoResponse.BookResponse;
import com.example.demo.model.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book save (Book book);
    Book remove(Long id);
    Book findById(Long id);
}
