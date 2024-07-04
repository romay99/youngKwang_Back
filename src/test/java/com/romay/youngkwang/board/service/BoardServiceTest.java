package com.romay.youngkwang.board.service;

import com.romay.youngkwang.board.dto.response.BoardResponseDTO;
import com.romay.youngkwang.board.repository.BoardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class BoardServiceTest {
    @Autowired private BoardService boardService;

    @Test
    @DisplayName("게시판 글 전체조회")
    public void getBoards() {
        //given
        Pageable pageable1 = PageRequest.of(0,1);
        Pageable pageable2 = PageRequest.of(0,3);
        //when
        List<BoardResponseDTO> boardList1 = boardService.getBoardList(pageable1);
        List<BoardResponseDTO> boardList2 = boardService.getBoardList(pageable2);

        //then
        assertEquals(boardList1.size(),1);
        assertEquals(boardList2.size(),3);
    }

}