package com.romay.youngkwang.board.controller;

import com.romay.youngkwang.board.domain.Board;
import com.romay.youngkwang.board.service.BoardService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "게시판")
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/home")
    public ResponseEntity<?> boardHome() {
        List<Board> boardList = boardService.getBoardList();
        return ResponseEntity.ok().body(boardList);
    }
}
