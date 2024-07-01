package com.romay.youngkwang.board.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.romay.youngkwang.board.domain.Board;
import com.romay.youngkwang.board.dto.request.BoardSearchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.romay.youngkwang.board.domain.QBoard.board;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomBoardRepositoryImpl implements CustomBoardRepository {
    private final JPAQueryFactory qf;

    @Override
    public List<Board> searchBoardWithFilter(BoardSearchDTO boardSearchDTO) {
        return qf.selectFrom(board)
                .where(contentFilter(boardSearchDTO),
                        titleFilter(boardSearchDTO),
                        userNameFilter(boardSearchDTO))
                .fetch();
    }

    BooleanExpression contentFilter(BoardSearchDTO boardSearchDTO) {
        String content = boardSearchDTO.getContent();
        if (content == null) {
            return null;
        }
        return board.boardContent.contains(content);
    }
    BooleanExpression titleFilter(BoardSearchDTO boardSearchDTO) {
        String title = boardSearchDTO.getTitle();
        if (title == null) {
            return null;
        }
        return board.boardTitle.contains(title);
    }
    BooleanExpression userNameFilter(BoardSearchDTO boardSearchDTO) {
        String userName = boardSearchDTO.getUserName();
        if (userName == null) {
            return null;
        }
        return board.user.userName.eq(userName);
    }
}
