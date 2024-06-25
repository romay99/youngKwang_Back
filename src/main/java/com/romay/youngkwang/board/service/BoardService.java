package com.romay.youngkwang.board.service;

import com.romay.youngkwang.board.domain.Board;
import com.romay.youngkwang.board.dto.request.BoardPostDTO;
import com.romay.youngkwang.board.dto.response.BoardDetailViewDTO;
import com.romay.youngkwang.board.dto.response.BoardResponseDTO;
import com.romay.youngkwang.board.repository.BoardRepository;
import com.romay.youngkwang.boardComment.service.BoardCommentService;
import com.romay.youngkwang.user.domain.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardCommentService boardCommentService;

    public BoardService(BoardRepository boardRepository, BoardCommentService boardCommentService) {
        this.boardRepository = boardRepository;
        this.boardCommentService = boardCommentService;
    }

    // 게시물 전체 조회
    public List<BoardResponseDTO> getBoardList() {
        return boardRepository.findAll().stream()
                .map(entity -> BoardResponseDTO.builder()
                        .boardTitle(entity.getBoardTitle())
                        .boardCode(entity.getBoardCode())
                        .boardDate(entity.getBoardDate())
                        .boardView(entity.getBoardView())
                        .userNickName(entity.getUser().getUserNickName())
                        .build()).toList();
    }

    // 게시물 상세 조회
    public BoardDetailViewDTO getBoardDetail(Long boardCode) {
        System.out.println("boardCode = " + boardCode);
        Optional<Board> boardEntity = boardRepository.findById(boardCode);
        if (boardEntity.isPresent()) {
            BoardDetailViewDTO boardDetailViewDTO = new BoardDetailViewDTO();
            Board board = boardEntity.get();
            boardDetailViewDTO.setBoardTitle(board.getBoardTitle());
            boardDetailViewDTO.setBoardCode(board.getBoardCode());
            boardDetailViewDTO.setBoardContent(board.getBoardContent());
            boardDetailViewDTO.setBoardDate(board.getBoardDate());
            boardDetailViewDTO.setBoardViewCount(board.getBoardView());
            boardDetailViewDTO.setUserName(board.getUser().getUserNickName());
            boardDetailViewDTO.setBoardCommentList(boardCommentService.getBoardComments(boardCode));

            return boardDetailViewDTO;
        }
        return null;
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
