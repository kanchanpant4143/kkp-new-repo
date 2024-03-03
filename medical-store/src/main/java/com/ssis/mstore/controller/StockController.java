package com.ssis.mstore.controller;

import com.ssis.mstore.model.Stock;
import com.ssis.mstore.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @PostMapping(value = "/add")
    public ResponseEntity<Stock> addTodo(@RequestBody Stock stock) {
        System.out.println("Print request data " + stock.toString());
        Stock stockDto = null;
        try {
            stockDto = stockService.addStock(stock);
            System.out.println("Print data " + stockDto.toString());
            return ResponseEntity.ok().body(stockDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /*@GetMapping(value = "/list")
    public ResponseEntity<List<TodoDto>> getAllTodo() {
        List<TodoDto> todoList = todoService.getAllTodos();
        return ResponseEntity.ok().body(todoList);
    }

    @DeleteMapping(value = "/delete/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("todoId") Integer todoId) {
        System.out.println("Print path variable " + todoId);
        try {
            todoService.deleteTodo(todoId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/get/{todoId}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("todoId") Integer todoId) {
        System.out.println("Print path variable " + todoId);
        try {
            TodoDto todoDto = todoService.getTodoById(todoId);
            return ResponseEntity.ok().body(todoDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "/update/{todoId}")
    public ResponseEntity<TodoDto> addTodo(@PathVariable("todoId") Integer todoId, @RequestBody TodoDto todo) {
        System.out.println("Print request data " + todo.toString());
        TodoDto todoDto = null;
        try {
            todoDto = todoService.updateTodo(todo);
            System.out.println("Print data " + todoDto.toString());
            return ResponseEntity.ok().body(todoDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }*/

}
