package YangHeeChan.demo.service;

import YangHeeChan.demo.entity.Book;
import YangHeeChan.demo.entity.Borrowing;
import YangHeeChan.demo.entity.Member;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequestMapping("/borrowings")
public class BorrowingService {
    private BookService bookService;
    private MemberService memberService;
    private int autoIncrement = 1;
    private List<Borrowing> borrowings = new ArrayList<>();

    Date date = new Date();

    public BorrowingService(BookService bookService, MemberService memberService) {
        this.bookService = bookService;
        this.memberService = memberService;
    }

    public boolean BorrowingBook(int memberId, int bookId) {
        for (Borrowing borrowing : borrowings) {
            borrowing.setBook(bookService.getBookById((bookId)));
            borrowing.setMember(memberService.getMemberById(memberId));
            borrowing.setId(autoIncrement++);
            borrowing.setStartTime(date);
            borrowings.add(borrowing);
        }
        return true;
    }

    public List<Borrowing> getBorrowings() {
        return borrowings;
    }

    public Borrowing getBorrowingById(int memberId, int bookId) {
        if (memberId == 0 && bookId != 0) {
            for (Borrowing borrowing : borrowings) {
                if (borrowing.getBook().getId() == bookId) {
                    return borrowing;
                }
            }
        }
        if (memberId != 0 && bookId == 0) {
            for (Borrowing borrowing : borrowings) {
                if (borrowing.getMember().getId() == memberId) {
                    return borrowing;
                }
            }
        }
        if (memberId != 0 && bookId != 0) {
            for (Borrowing borrowing : borrowings) {
                if (borrowing.getMember().getId() == memberId) {
                    return borrowing;
                }
            }
        }
        if (memberId == 0 && bookId == 0) {
            return null;
        }

        return null;
    }

    public boolean returnBorrowing(int bookId) {
        return true;
    }

    public boolean extensionBorrowing(int bookId) {
        return true;
    }

    public boolean deleteBorrowing(int memberId) {
        for (Borrowing borrowing : borrowings) {
            if (borrowing.getMember().getId() ==memberId) {
                borrowings.remove(borrowing);
            }
        }
    return true;
    }
}