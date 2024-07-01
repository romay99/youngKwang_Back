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

    @OneToMany
    private List<User> user;

    @OneToMany
    private List<Badge> badge;
}
