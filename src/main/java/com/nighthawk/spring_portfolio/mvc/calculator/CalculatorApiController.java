package com.nighthawk.spring_portfolio.mvc.calculator;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/calculator")
public class CalculatorApiController {
    
    @GetMapping("/calculate/{expression}")
    public ResponseEntity<String> getDayOfYear(@PathVariable String expression) {
      
      Calculator equation = new Calculator(expression);
      String finalAnswer = equation.toString();
      return ResponseEntity.ok(finalAnswer);  
    }

}