package com.romay.youngkwang.boardComment.controller;

import com.romay.youngkwang.boardComment.service.BoardCommentService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Tag(name = "자유게시판 댓글",description = "자유게시판에 댓글 관련 기능입니다")
@RequestMapping("/boardComment")
@RequiredArgsConstructor
public class BoardCommentController {

    private final BoardCommentService boardCommentService;

    @PostMapping("/comment")
    @ApiResponse(responseCode = "200",description = "댓글을 작성하는 기능입니다.")
    public ResponseEntity<?> postBoardComment(@RequestParam Long boardCode,@RequestParam String content) {
        boardCommentService.postBoardComment(boardCode,content);
        return ResponseEntity.ok().build();
    }

}
