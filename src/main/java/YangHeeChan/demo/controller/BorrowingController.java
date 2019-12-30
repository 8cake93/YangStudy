package YangHeeChan.demo.controller;

import YangHeeChan.demo.entity.Borrowing;
import YangHeeChan.demo.service.BorrowingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {
    private BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService){
        this.borrowingService = borrowingService;
    }

    @PostMapping("/{memberId}/{bookId}")
    public Boolean BorrowingBook(@PathVariable int memberId,@PathVariable int bookId){
        return borrowingService.BorrowingBook(memberId,bookId);
    }

    @GetMapping("")
    public List<Borrowing> getBorrowings(@RequestParam(value="memberId",required = false, defaultValue = "0") int memberId,
                                         @RequestParam(value="bookId",required = false, defaultValue = "0") int bookId){
        return borrowingService.getBorrowings(memberId,bookId);
    }

    @GetMapping("")
    public Borrowing getBorrowingById(int memberId){
        return borrowingService.getBorrowingById(memberId);
    }

    @PatchMapping("/return/books/{bookId}")
    public boolean returnBorrowing(@PathVariable int bookId){
        return borrowingService.returnBorrowing(bookId);
    }
    @PatchMapping("/extension/books/{bookId}")
    public boolean extensionBorrowing(@PathVariable int bookId){
        return borrowingService.extensionBorrowing(bookId);
    }

    @DeleteMapping("/{memberId}")
    public boolean deleteBorrowing(@PathVariable int memberId){
        return borrowingService.deleteBorrowing(memberId);
    }
}
