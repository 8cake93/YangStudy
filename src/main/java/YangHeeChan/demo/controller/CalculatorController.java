package YangHeeChan.demo.controller;

import YangHeeChan.demo.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService=calculatorService;
    }

    @GetMapping("/sum")
    public int sum(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.sum(num1,num2);
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.mul(num1,num2);
    }

    @GetMapping("/substarct")
    public int substarct(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.sub(num1,num2);
    }

    @GetMapping("/divide")
    public int divide(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.div(num1,num2);
    }
}