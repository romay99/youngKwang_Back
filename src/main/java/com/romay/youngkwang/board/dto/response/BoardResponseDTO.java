package com.romay.youngkwang.board.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BoardResponseDTO {
    private Long boardCode;
    private String boardTitle;
    private String boardContent;
    private Date boardDate;
    private Long boardView;
    private Long userCode;
}
