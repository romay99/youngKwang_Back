package com.romay.youngkwang.boardComment.service;

import com.romay.youngkwang.boardComment.domain.BoardComment;
import com.romay.youngkwang.boardComment.dto.response.BoardCommentResponseDTO;
import com.romay.youngkwang.boardComment.repository.BoardCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardCommentService {
    private final BoardCommentRepository boardCommentRepository;

    // 한 게시물의 댓글 리스트 가져오는 메서드
    public List<BoardCommentResponseDTO> getBoardComments(Long boardCode) {
        List<BoardComment> boardCommentList = boardCommentRepository.findAll();
        return  boardCommentList.stream().map(
                entity -> BoardCommentResponseDTO.builder()
                        .boardCommentCode(entity.getBoardCommentId())
                        .boardCommentDate(entity.getBoardCommentDate())
                        .boardCommentContent(entity.getBoardCommentContent())
                        .userNickName(entity.getUser().getUserNickName())
                        .build()).toList();
    }

    //댓글 작성 메서드
    public void postBoardComment(Long boardCode,String content) {
        Long userCode = 1L ; // 임시 유저코드

        BoardComment boardComment = BoardComment.createBoardComment(boardCode, userCode, content);
        boardCommentRepository.save(boardComment);

    }
}
