package YangHeeChan.demo.service;

import YangHeeChan.demo.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();
    private int autoIncrement=1;

    public Boolean saveBook(Book newBook){
        newBook.setId(autoIncrement++);
        books.add(newBook);

        return true;
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book getBookById(int id){
        for(Book book:books){
            if(book.getId()==id){
                return book;
            }
        }
        return null;
    }

    public Book putBook(int id,Book puttedBook){
        for(Book book:books){
            if(book.getId()==id){
                book.setAuthor(puttedBook.getAuthor());
                book.setTitle(puttedBook.getTitle());
                return book;
            }
        }
        return null;
    }
    public Boolean deleteBook(int id){
        for(Book book:books){
            if(book.getId()==id){
                books.remove(book);
            }
        }
        return true;
    }
    public void isOutBook(int bookId,boolean tt){
        for(Book book:books){
            if(book.getId()==bookId){
                book.setOut(tt);
            }
        }
    }
}
