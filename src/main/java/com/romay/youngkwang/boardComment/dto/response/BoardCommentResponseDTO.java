package com.romay.youngkwang.boardComment.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardCommentResponseDTO {
    private Long boardCommentCode;
    private String boardCommentContent;
    private LocalDate boardCommentDate;
    private String userNickName;

}
