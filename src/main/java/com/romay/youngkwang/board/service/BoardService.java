package com.romay.youngkwang.board.service;

import com.romay.youngkwang.board.domain.Board;
import com.romay.youngkwang.board.dto.response.BoardResponseDTO;
import com.romay.youngkwang.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

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
}
