package com.romay.youngkwang.board.service;

import com.romay.youngkwang.board.dto.request.BoardPostDTO;
import com.romay.youngkwang.board.dto.request.BoardSearchDTO;
import com.romay.youngkwang.board.dto.response.BoardResponseDTO;
import com.romay.youngkwang.board.repository.BoardRepository;
import com.romay.youngkwang.user.domain.User;
import com.romay.youngkwang.user.repository.UserRepository;
import com.romay.youngkwang.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
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
    @Autowired private BoardService boardService;
    @Autowired private BoardRepository boardRepository;

    @Test
    @DisplayName("게시물 필터 검색")
    public void searchBoard() throws Exception{
        //given
        BoardPostDTO DTO1 = new BoardPostDTO();
        DTO1.setTitle("테스트용제목");
        DTO1.setContent("테스트용내용");

        BoardPostDTO DTO2 = new BoardPostDTO();
        DTO2.setTitle("블라블라");
        DTO2.setContent("블라블라");

        boardService.postBoard(DTO1);
        boardService.postBoard(DTO2);

        BoardSearchDTO titleSearch = new BoardSearchDTO();
        titleSearch.setTitle("테스트");

        BoardSearchDTO contentSearch = new BoardSearchDTO();
        contentSearch.setContent("테스트");

        //when
        List<BoardResponseDTO> responseWithTitle = boardService.searchBoards(titleSearch);
        List<BoardResponseDTO> responseWithContent = boardService.searchBoards(contentSearch);

        //then
        assertEquals(responseWithTitle.size(), 1);
        assertEquals(responseWithContent.size(), 1);
    }
}