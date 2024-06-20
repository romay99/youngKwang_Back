package com.romay.youngkwang.boardComment.repository;

import com.romay.youngkwang.boardComment.domain.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardCommentRepository extends JpaRepository<BoardComment, Long> {

    @Query("select b from BoardComment b where b.board.boardCode = :boardCode")
    List<BoardComment> findAllByBoardCode(Long boardCode);
}
