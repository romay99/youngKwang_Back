package com.romay.youngkwang.board.dto.response;

import com.romay.youngkwang.boardComment.dto.response.BoardCommentResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class BoardDetailViewDTO {
    private Long boardCode;
    private String boardTitle;
    private String boardContent;
    private String userName;
    private Long boardViewCount;
    private LocalDate boardDate;
    private List<BoardCommentResponseDTO> boardCommentList;
}
