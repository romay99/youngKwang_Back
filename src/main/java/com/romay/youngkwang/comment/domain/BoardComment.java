package com.romay.youngkwang.comment.domain;

import com.romay.youngkwang.board.domain.Board;
import com.romay.youngkwang.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "board_comment")
@Getter
public class BoardComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardCommentId;

    @Column(name = "board_comment_content")
    private String boardCommentContent;

    @Column(name = "board_comment_date")
    private LocalDate boardCommentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_code")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_code")
    private User user;

}
