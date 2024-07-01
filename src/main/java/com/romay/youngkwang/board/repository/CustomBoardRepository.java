package com.romay.youngkwang.board.repository;

import com.romay.youngkwang.board.domain.Board;
import com.romay.youngkwang.board.dto.request.BoardSearchDTO;

import java.util.List;

public interface CustomBoardRepository {
    List<Board> searchBoardWithFilter(BoardSearchDTO boardSearchDTO);
}
