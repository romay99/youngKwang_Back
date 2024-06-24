package com.romay.youngkwang.board.controller;

import com.romay.youngkwang.board.dto.request.BoardPostDTO;
import com.romay.youngkwang.board.dto.response.BoardResponseDTO;
import com.romay.youngkwang.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "게시판")
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/post")
    @Operation(summary = "자유게시판 글작성",description = "자유게시판 글작성 기능입니다")
    @ApiResponse(responseCode = "200",description = "글작성 성공시 200")
    public ResponseEntity<?> postBoard(@RequestBody BoardPostDTO DTO){
        boardService.postBoard(DTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/home")
    @Operation(summary = "자유게시판 글조회",description = "자유게시판 글 조회")
    @ApiResponse(responseCode ="200",description = "성공시 JSON 들의 리스트를 응답",
            content = @Content(schema = @Schema(implementation = BoardResponseDTO.class)))
    public ResponseEntity<?> boardHome() {
        List<BoardResponseDTO> boardList = boardService.getBoardList();
        return ResponseEntity.ok().body(boardList);
    }
}
