package com.romay.youngkwang.boardComment.service;

import com.romay.youngkwang.boardComment.domain.BoardComment;
import com.romay.youngkwang.boardComment.dto.response.BoardCommentResponseDTO;
import com.romay.youngkwang.boardComment.repository.BoardCommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardCommentService {
    private final BoardCommentRepository boardCommentRepository;

    public BoardCommentService(BoardCommentRepository boardCommentRepository) {
        this.boardCommentRepository = boardCommentRepository;
    }

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
}
