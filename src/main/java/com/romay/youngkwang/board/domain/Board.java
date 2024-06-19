package com.romay.youngkwang.board.domain;

import com.romay.youngkwang.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "board")
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_code")
    private Long boardCode;

    @Column(name = "board_title")
    private String boardTitle;

    @Column(name = "board_content")
    private String boardContent;

    @Column(name = "board_date")
    private LocalDate boardDate;

    @Column(name = "board_view")
    private Long boardView;

    @JoinColumn(name = "user_code")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    // 조회수 추가 로직
    public void increaseView(){
        this.boardView ++ ;
    }

    public void decreaseView(){
        this.boardView --;
    }

    // 테스트용 게시글 생성 메서드


}
