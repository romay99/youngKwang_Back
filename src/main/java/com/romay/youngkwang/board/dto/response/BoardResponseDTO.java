package com.romay.youngkwang.board.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardResponseDTO {
    private Long boardCode;
    private String boardTitle;
    private String boardContent;
    private LocalDate boardDate;
    private Long boardView;
    private String userNickName;
}
