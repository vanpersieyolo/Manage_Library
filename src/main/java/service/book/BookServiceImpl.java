package service.book;

import com.example.demo.model.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService{
    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public Book remove(Long id) {
        return null;
    }

    @Override
    public Book findById(Long id) {
        return null;
    }
}
