package com.romay.youngkwang.boardComment.controller;

import com.romay.youngkwang.boardComment.dto.response.BoardCommentResponseDTO;
import com.romay.youngkwang.boardComment.service.BoardCommentService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "자유게시판 댓글")
@RequestMapping("/board/comment")
public class BoardCommentController {

    private final BoardCommentService boardCommentService;

    public BoardCommentController(BoardCommentService boardCommentService) {
        this.boardCommentService = boardCommentService;
    }

    @GetMapping("/view")
    @ApiResponse(responseCode = "200",description = "한 게시물의 댓글들의 리스트를 반환",content =
    @Content(schema = @Schema(implementation = BoardCommentResponseDTO.class)))
    public ResponseEntity<?> getBoardComment(@RequestParam("board") Long boardCode) {
        List<BoardCommentResponseDTO> boardComments = boardCommentService.getBoardComments(boardCode);
        return ResponseEntity.ok(boardComments);
    }
}
