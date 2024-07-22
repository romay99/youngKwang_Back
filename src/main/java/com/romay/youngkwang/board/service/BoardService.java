package com.romay.youngkwang.board.service;

import com.romay.youngkwang.board.domain.Board;
import com.romay.youngkwang.board.dto.request.BoardPostDTO;
import com.romay.youngkwang.board.dto.request.BoardSearchDTO;
import com.romay.youngkwang.board.dto.response.BoardDetailViewDTO;
import com.romay.youngkwang.board.dto.response.BoardResponseDTO;
import com.romay.youngkwang.board.repository.BoardRepository;
import com.romay.youngkwang.boardComment.service.BoardCommentService;
import com.romay.youngkwang.user.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
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
    public List<BoardResponseDTO> getBoardList(Pageable pageable) {
        return boardRepository.findAll(pageable).stream()
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
        Board board = boardRepository.findById(boardCode).orElseThrow(()->new NoSuchElementException("게시물이 존재하지 않습니다."));

        BoardDetailViewDTO boardDetailViewDTO = new BoardDetailViewDTO();
        boardDetailViewDTO.setBoardTitle(board.getBoardTitle());
        boardDetailViewDTO.setBoardCode(board.getBoardCode());
        boardDetailViewDTO.setBoardContent(board.getBoardContent());
        boardDetailViewDTO.setBoardDate(board.getBoardDate());
        boardDetailViewDTO.setBoardViewCount(board.getBoardView());
        boardDetailViewDTO.setUserName(board.getUser().getUserNickName());
        boardDetailViewDTO.setBoardCommentList(boardCommentService.getBoardComments(boardCode));

        return boardDetailViewDTO;
    }

    //자유게시판 글쓰기
    public Long postBoard(BoardPostDTO DTO) {
         // 유저코드 토큰에서 가져오는걸로 바꿔야함.
        Long userCode = 1L;

        Board boardEntity = Board.builder()
                .boardView(0L)
                .boardDate(LocalDate.now())
                .boardTitle(DTO.getTitle())
                .boardContent(DTO.getContent())
                .user(User.createTestUser(userCode))
                .build();

        boardRepository.save(boardEntity);
        return boardEntity.getBoardCode();

    }

    public List<BoardResponseDTO> searchBoards(BoardSearchDTO boardSearchDTO) {
        List<Board> boardList = boardRepository.searchBoardWithFilter(boardSearchDTO);
        return boardList.stream().map(
                entity -> BoardResponseDTO.builder()
                        .boardTitle(entity.getBoardTitle())
                        .boardCode(entity.getBoardCode())
                        .boardDate(entity.getBoardDate())
                        .boardView(entity.getBoardView())
                        .userNickName(entity.getUser().getUserNickName())
                        .build())
                .toList();
    }
}
