package com.romay.youngkwang.board.controller;

import com.romay.youngkwang.board.dto.request.BoardPostDTO;
import com.romay.youngkwang.board.dto.request.BoardSearchDTO;
import com.romay.youngkwang.board.dto.response.BoardDetailViewDTO;
import com.romay.youngkwang.board.dto.response.BoardResponseDTO;
import com.romay.youngkwang.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "게시판",description = "게시판 관련 기능입니다")
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/post")
    @Operation(summary = "자유게시판 글작성", description = "자유게시판 글작성 기능입니다")
    @ApiResponse(responseCode = "200", description = "글작성 성공시 200")
    public ResponseEntity<?> postBoard(@RequestBody BoardPostDTO DTO) {
        boardService.postBoard(DTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/home")
    @Operation(summary = "자유게시판 홈", description = "자유게시판 글 조회")
    @ApiResponse(responseCode = "200", description = "성공시 JSON 들의 리스트를 응답",
            content = @Content(schema = @Schema(implementation = BoardResponseDTO.class)))
    public ResponseEntity<?> boardHome(@ParameterObject Pageable pageable) {
        List<BoardResponseDTO> boardList = boardService.getBoardList(pageable);
        return ResponseEntity.ok().body(boardList);
    }

    @GetMapping("/view")
    @Operation(summary = "게시물 상세 조회", description = "자유게시판 글 상세페이지입니다. ")
    @ApiResponse(responseCode = "200", description = "게시물의 내용과 댓글들을 List 로 응답해줍니다."
            , content = @Content(schema = @Schema(implementation = BoardDetailViewDTO.class)))
    @ApiResponse(responseCode = "404", description = "boardCode 에 매칭되는 게시물이 존재하지 않을시 404 코드를 응답합니다.")
    public ResponseEntity<?> boardView(@RequestParam Long boardCode) {
        BoardDetailViewDTO boardDetail = boardService.getBoardDetail(boardCode);
        return ResponseEntity.ok().body(boardDetail);
    }

    @GetMapping("/search")
    @Operation(summary = "게시물 검색",description = "필터를 이용한 게시글 검색기능입니다")
    @ApiResponse(responseCode = "200",description = "필터를 이용한 게시글들의 List 를 응답해줍니다",
            content = @Content(schema = @Schema(implementation = BoardResponseDTO.class)))
    public ResponseEntity<?> searchBoardList(BoardSearchDTO boardSearchDTO) {
        List<BoardResponseDTO> dtoList = boardService.searchBoards(boardSearchDTO);
        return ResponseEntity.ok().body(dtoList);
    }
}
