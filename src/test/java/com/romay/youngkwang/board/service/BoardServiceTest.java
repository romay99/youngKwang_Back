package com.romay.youngkwang.board.service;

import com.romay.youngkwang.board.dto.response.BoardResponseDTO;
import com.romay.youngkwang.board.repository.BoardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class BoardServiceTest {
    @Autowired private BoardRepository boardRepository;
    @Autowired private BoardService boardService;

    @DisplayName("전체 글 불러오기")
    @Test
    void getBoardList() {
        // given
        List<BoardResponseDTO> boardList = boardService.getBoardList();

        // when

        // then
        assertEquals(boardList.size(),3);
    }

}