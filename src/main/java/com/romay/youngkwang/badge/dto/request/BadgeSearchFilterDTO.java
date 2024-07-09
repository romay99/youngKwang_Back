package com.romay.youngkwang.badge.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadgeSearchFilterDTO {
    private String badgeName;
    private String badgeCategory;
    private String badgeRate;
}
