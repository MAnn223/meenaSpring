package com.nighthawk.spring_portfolio.mvc.lightboard;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/lightboard")
public class LightboardApiController {
    
    @GetMapping("/{rows}/{cols}")
    public ResponseEntity<String> getLightBoard(@PathVariable int rows, @PathVariable int cols) {
      
      LightBoard lightBoard = new LightBoard(rows, cols);
      String finalToString = lightBoard.toString();
      return ResponseEntity.ok(finalToString);  
    }

    @GetMapping("/turnAllLightsOn/{rows}/{cols}")
    public ResponseEntity<String> turnAllLightsOn(@PathVariable int rows, @PathVariable int cols) {
      
      LightBoard lightBoard = new LightBoard(rows, cols);
      lightBoard.turnAllLightsOn();
      String finalToString = lightBoard.toString();
      return ResponseEntity.ok("All lights turned on: " + "\n" + finalToString);  
    }

    @GetMapping("/turnAllLightsOff/{rows}/{cols}")
    public ResponseEntity<String> turnAllLightsOff(@PathVariable int rows, @PathVariable int cols) {
      
      LightBoard lightBoard = new LightBoard(rows, cols);
      lightBoard.turnAllLightsOff();
      String finalToString = lightBoard.toString();
      return ResponseEntity.ok("All lights turned off: " + "\n" + finalToString);  
    }

    @GetMapping("/turnLightsOn/{rows}/{cols}/{row1}/{col1}")
    public ResponseEntity<String> turnLightOn(@PathVariable int rows, @PathVariable int cols, @PathVariable int row1, @PathVariable int col1) {
      
      LightBoard lightBoard = new LightBoard(rows, cols);
      //lightBoard.turnAllLightsOn();
      lightBoard.turnOnLight(row1,col1);
      String finalToString = lightBoard.toString();
      return ResponseEntity.ok("Turned on light " + "row: " + row1 + " col: " + col1 + "\n" + finalToString);  
    }
    
    @GetMapping("/turnLightsOff/{rows}/{cols}/{row1}/{col1}")
    public ResponseEntity<String> turnLightOff(@PathVariable int rows, @PathVariable int cols, @PathVariable int row1, @PathVariable int col1) {
      
      LightBoard lightBoard = new LightBoard(rows, cols);
      lightBoard.turnAllLightsOn();
      lightBoard.turnOffLight(row1,col1);
      String finalToString = lightBoard.toString();
      return ResponseEntity.ok("Turned off light " + "row: " + row1 + " col: " + col1 + "\n" + finalToString);  
    }

}