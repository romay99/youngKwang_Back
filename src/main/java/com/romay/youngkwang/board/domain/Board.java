package com.romay.youngkwang.board.domain;

import com.romay.youngkwang.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "board")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "board_recommend")
    private int boardRecommend;

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

    //임시 Board 엔티티 리턴하는 메서드
    public static Board createTempBoard(Long boardCode) {
        Board board = new Board();
        board.boardCode = boardCode;
        return board;
    }



}
