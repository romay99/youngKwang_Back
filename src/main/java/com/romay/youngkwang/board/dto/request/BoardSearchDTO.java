package com.romay.youngkwang.board.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardSearchDTO {
    private String title;
    private String userNickName;
    private String content;
}
