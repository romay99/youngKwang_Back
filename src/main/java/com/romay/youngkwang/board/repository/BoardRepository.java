package com.romay.youngkwang.board.repository;

import com.romay.youngkwang.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>,CustomBoardRepository {

    @Override
    @EntityGraph(attributePaths = {"user"})
    Page<Board> findAll(Pageable pageable);
}
