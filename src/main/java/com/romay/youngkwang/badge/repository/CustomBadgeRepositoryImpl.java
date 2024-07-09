package com.romay.youngkwang.badge.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.romay.youngkwang.badge.domain.Badge;
import com.romay.youngkwang.badge.dto.request.BadgeSearchFilterDTO;
import lombok.RequiredArgsConstructor;
import static com.romay.youngkwang.badge.domain.QBadge.badge;

import java.util.List;

@RequiredArgsConstructor
public class CustomBadgeRepositoryImpl implements CustomBadgeRepository {

    private final JPAQueryFactory qf;

    @Override
    public List<Badge> searchBadgeWithFilter(BadgeSearchFilterDTO badgeSearchFilterDTO) {
        return qf.selectFrom(badge)
                .where(nameFilter(badgeSearchFilterDTO),
                        categoryFilter(badgeSearchFilterDTO),
                        rateFilter(badgeSearchFilterDTO))
                .fetch();
    }

    private BooleanExpression nameFilter(BadgeSearchFilterDTO badgeSearchFilterDTO) {
        if(badgeSearchFilterDTO.getBadgeName() == null) {
            return null;
        }
        return badge.badgeName.contains(badgeSearchFilterDTO.getBadgeName());
    }
    private BooleanExpression categoryFilter(BadgeSearchFilterDTO badgeSearchFilterDTO) {
        if(badgeSearchFilterDTO.getBadgeCategory() == null) {
            return null;
        }
        return badge.badgeCategory.eq(badgeSearchFilterDTO.getBadgeCategory());
    }
    private BooleanExpression rateFilter(BadgeSearchFilterDTO badgeSearchFilterDTO) {
        if(badgeSearchFilterDTO.getBadgeRate() == null) {
            return null;
        }
        return badge.badgeRate.eq(badgeSearchFilterDTO.getBadgeRate());
    }
}
