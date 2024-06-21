package com.romay.youngkwang.board.controller;

import com.romay.youngkwang.board.dto.response.BoardResponseDTO;
import com.romay.youngkwang.board.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @ApiResponse(description = "자유게시판 게시물 목록 불러오는 기능")
    public ResponseEntity<?> boardHome() {
        List<BoardResponseDTO> boardList = boardService.getBoardList();
        return ResponseEntity.ok().body(boardList);
    }
}
