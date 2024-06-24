package com.romay.youngkwang.board.service;

import com.romay.youngkwang.board.domain.Board;
import com.romay.youngkwang.board.dto.request.BoardPostDTO;
import com.romay.youngkwang.board.dto.response.BoardResponseDTO;
import com.romay.youngkwang.board.repository.BoardRepository;
import com.romay.youngkwang.user.domain.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 게시물 전체 조회
    public List<BoardResponseDTO> getBoardList() {
        return boardRepository.findAll().stream()
                .map(entity -> BoardResponseDTO.builder()
                        .boardTitle(entity.getBoardTitle())
                        .boardCode(entity.getBoardCode())
                        .boardContent(entity.getBoardContent())
                        .boardDate(entity.getBoardDate())
                        .boardView(entity.getBoardView())
                        .userNickName(entity.getUser().getUserNickName())
                        .build()).toList();
    }

    //자유게시판 글쓰기
    public void postBoard(BoardPostDTO DTO) {
        Long userCode = 1L; // 임시 유저코드 토큰에서 가져오는걸로 바꿔야함.

        Board boardEntity = Board.builder()
                .boardView(0L)
                .boardDate(LocalDate.now())
                .boardTitle(DTO.getTitle())
                .boardContent(DTO.getContent())
                .user(User.createTestUser(userCode))
                .build();

        boardRepository.save(boardEntity);

    }
}
