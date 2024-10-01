package com.multi.mvc.board.controller;

import com.multi.mvc.board.service.BoardService;
import com.multi.mvc.board.vo.Board;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
@Slf4j
@RequiredArgsConstructor
public class BoardRestController {

    private final BoardService service;


    @PostMapping("/board")
    public ResponseEntity<Board> create(@RequestBody Board board) {
        Board result = service.write(board);
        if(result == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/board/{bno}")
    public ResponseEntity<Board> update(@PathVariable Long bno, @RequestBody Board board) {
        board.setBno(bno);
        Board result = service.update(board);
        if(result == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/board/{bno}")
    public ResponseEntity<Board> delete(@PathVariable Long bno) {
        Board result = service.delete(bno);
        if(result == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(result);
    }
}
