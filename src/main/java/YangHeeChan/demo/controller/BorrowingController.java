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

    @PostMapping("/members/{memberId}/books/{bookId}")
    public Boolean BorrowingBook(@PathVariable int memberId,@PathVariable int bookId){
        return borrowingService.BorrowingBook(memberId,bookId);
    }

    @GetMapping("/all")
    public List<Borrowing> getBorrowings(){
        return borrowingService.getBorrowings();
    }

    @GetMapping()
    public Borrowing getBorrowingById(@RequestParam(value="memberId",required = false, defaultValue = "0") int memberId,
                                      @RequestParam(value="bookId",required = false, defaultValue = "0") int bookId){
        return borrowingService.getBorrowingById(memberId,bookId);
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
