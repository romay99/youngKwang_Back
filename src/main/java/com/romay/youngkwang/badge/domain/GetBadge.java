package com.romay.youngkwang.badge.domain;

import com.romay.youngkwang.user.domain.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class GetBadge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long getBadgeCode;

    private LocalDateTime getBadgeDate;

    @ManyToOne
    @JoinColumn(name = "user_code")
    private User userCode;

    @ManyToOne
    @JoinColumn(name = "badge_Code")
    private Badge badgeCode;
}
