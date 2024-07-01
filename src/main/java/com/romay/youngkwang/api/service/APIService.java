package com.romay.youngkwang.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class APIService {

    @Value("${api.key}")
    private String apiKey;

}

