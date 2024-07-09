package com.romay.youngkwang.api.service;

import com.romay.youngkwang.api.dto.response.NowPlayingMoviesResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class TmdbServiceTest {
    @Autowired TmdbService tmdbService;

    @Test
    @DisplayName("현재 상영작 불러오기")
    public void getNowPlaying(){
        //given
        int page = 1;

        //when
        List<NowPlayingMoviesResponseDTO> dtoList = tmdbService.nowPlaying(page);

        //then
        assertNotNull(dtoList);
    }

}