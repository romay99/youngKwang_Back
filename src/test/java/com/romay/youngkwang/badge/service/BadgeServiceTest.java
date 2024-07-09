package com.romay.youngkwang.badge.service;

import com.romay.youngkwang.badge.dto.request.BadgeSearchFilterDTO;
import com.romay.youngkwang.badge.dto.response.BadgeResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class BadgeServiceTest {
    @Autowired private BadgeService badgeService;

    @Test
    @DisplayName("뱃지 필터 검색기능")
    public void searchBadgeWithFilter() {
        //given
        BadgeSearchFilterDTO nameFilter = new BadgeSearchFilterDTO();
        BadgeSearchFilterDTO categoryFilter = new BadgeSearchFilterDTO();
        BadgeSearchFilterDTO rateFilter = new BadgeSearchFilterDTO();
        BadgeSearchFilterDTO noneFilter = new BadgeSearchFilterDTO();

        nameFilter.setBadgeName("이벤트");
        categoryFilter.setBadgeCategory("EVENT");
        rateFilter.setBadgeRate("BRONZE");

        //when
        List<BadgeResponseDTO> searchWithName = badgeService.searchBadges(nameFilter);
        List<BadgeResponseDTO> searchWithCategory = badgeService.searchBadges(categoryFilter);
        List<BadgeResponseDTO> searchWithRate = badgeService.searchBadges(rateFilter);
        List<BadgeResponseDTO> nonFilter = badgeService.searchBadges(noneFilter);

        //then
        assertEquals(3,searchWithName.size());
        assertEquals(3,searchWithCategory.size());
        assertEquals(2,searchWithRate.size());
        assertEquals(6,nonFilter.size());

    }

}