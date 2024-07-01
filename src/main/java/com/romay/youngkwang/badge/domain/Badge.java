package com.romay.youngkwang.badge.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long badgeCode;

    private String badgeName;

    private String badgeCategory;

    private String badgeRate;

    private int badgeHasUserCount;

}
