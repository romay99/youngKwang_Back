package com.romay.youngkwang.badge.repository;

import com.romay.youngkwang.badge.domain.Badge;
import com.romay.youngkwang.badge.dto.request.BadgeSearchFilterDTO;

import java.util.List;

public class CustomBadgeRepositoryImpl implements CustomBadgeRepository {
    @Override
    public List<Badge> searchBadgeWithFilter(BadgeSearchFilterDTO badgeSearchFilterDTO) {
        return List.of();
    }
}
