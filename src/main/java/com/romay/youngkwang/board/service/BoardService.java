package com.romay.youngkwang.board.service;

import com.romay.youngkwang.board.domain.Board;
import com.romay.youngkwang.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }
}
