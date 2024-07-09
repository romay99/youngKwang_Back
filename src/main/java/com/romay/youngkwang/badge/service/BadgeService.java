package com.romay.youngkwang.badge.service;

import com.romay.youngkwang.badge.domain.Badge;
import com.romay.youngkwang.badge.dto.request.BadgeSearchFilterDTO;
import com.romay.youngkwang.badge.dto.response.BadgeResponseDTO;
import com.romay.youngkwang.badge.repository.BadgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BadgeService {

    private final BadgeRepository badgeRepository;

    public List<BadgeResponseDTO> searchBadges(BadgeSearchFilterDTO badgeSearchFilterDTO) {
        List<Badge> badgeList = badgeRepository.searchBadgeWithFilter(badgeSearchFilterDTO);
        return badgeList.stream().map(entity ->
                BadgeResponseDTO.builder()
                        .badgeName(entity.getBadgeName())
                        .badgeCategory(entity.getBadgeName())
                        .badgeRate(entity.getBadgeRate())
                        .badgeHasUserCount(entity.getBadgeHasUserCount())
                        .build()).toList();
    }
}
