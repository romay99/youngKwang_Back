package com.romay.youngkwang.board.repository;

import com.romay.youngkwang.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>,CustomBoardRepository {
}
