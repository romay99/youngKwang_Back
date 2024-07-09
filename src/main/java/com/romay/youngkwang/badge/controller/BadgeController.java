package com.romay.youngkwang.badge.controller;

import com.romay.youngkwang.badge.dto.request.BadgeSearchFilterDTO;
import com.romay.youngkwang.badge.dto.response.BadgeResponseDTO;
import com.romay.youngkwang.badge.service.BadgeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/badge")
@RequiredArgsConstructor
@Tag(name = "뱃지",description = "뱃지관련 기능입니다")
public class BadgeController {
    private final BadgeService badgeService;

    @GetMapping("/search")
    @Operation(summary = "뱃지 검색",description = "필터를 이용한 뱃지 검색기능입니다. 모든 파라미터를 null 로 전달시 모든 뱃지를 응답합니다")
    @ApiResponse(responseCode = "200",description = "필터를 이용한 뱃지들의 List 를 응답해줍니다",
            content = @Content(schema = @Schema(implementation = BadgeResponseDTO.class)))
    public ResponseEntity<?> searchBoardList(BadgeSearchFilterDTO badgeSearchFilterDTO) {
        List<BadgeResponseDTO> dtoList = badgeService.searchBadges(badgeSearchFilterDTO);
        return ResponseEntity.ok().body(dtoList);
    }
}
