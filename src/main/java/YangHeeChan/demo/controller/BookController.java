package YangHeeChan.demo.controller;

import YangHeeChan.demo.entity.Book;
import YangHeeChan.demo.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Boolean saveBook(@RequestBody Book newBook){
        return bookService.saveBook(newBook);
    }
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId){
        return bookService.getBookById(bookId);
    }
    @PutMapping
    public Book putBook(@PathVariable("bookId") int bookId,@RequestBody Book puttedBook){
        return bookService.putBook(bookId,puttedBook);
    }
    @DeleteMapping
    public Boolean deleteBook(@PathVariable int bookId){
        return bookService.deleteBook(bookId);
    }

}
