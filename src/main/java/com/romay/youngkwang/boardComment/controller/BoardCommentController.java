package com.romay.youngkwang.boardComment.controller;

import com.romay.youngkwang.boardComment.domain.BoardComment;
import com.romay.youngkwang.boardComment.dto.response.BoardCommentResponseDTO;
import com.romay.youngkwang.boardComment.service.BoardCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "댓글")
@RequestMapping("/board/comment")
public class BoardCommentController {

    private final BoardCommentService boardCommentService;

    public BoardCommentController(BoardCommentService boardCommentService) {
        this.boardCommentService = boardCommentService;
    }


    @GetMapping("/view")
    public ResponseEntity<?> getBoardComment(@RequestParam("board") Long boardCode) {
        List<BoardCommentResponseDTO> boardComments = boardCommentService.getBoardComments(boardCode);
        return ResponseEntity.ok(boardComments);
    }
}
