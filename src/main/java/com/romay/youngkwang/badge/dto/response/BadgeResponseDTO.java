package com.romay.youngkwang.badge.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BadgeResponseDTO {
    private String badgeName;
    private String badgeCategory;
    private String badgeRate;
    private int badgeHasUserCount;
}
