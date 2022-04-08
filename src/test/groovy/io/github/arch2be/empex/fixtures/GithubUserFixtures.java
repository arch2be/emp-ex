package io.github.arch2be.empex.fixtures;

import io.github.arch2be.empex.application.dto.GithubUserDto;
import io.github.arch2be.empex.domain.GithubUser;

import java.time.LocalDateTime;

public class GithubUserFixtures {

    public static final String ARCH2BE_LOGIN = "arch2be";
    public static final Double CORRECT_CALCULATION_ARCH2BE = 6.0;

    public static final GithubUser ARCH2BE = GithubUser.of(
            28571918,
            ARCH2BE_LOGIN,
            "User",
            "https://avatars.githubusercontent.com/u/28571918?v=4",
            LocalDateTime.of(2017,5,9,16,57,21),
            "Mateusz",
            8,
            6);

    public static final GithubUserDto CORRECT_RESPONSE_ARCH2BE = new GithubUserDto(
            28571918,
            ARCH2BE_LOGIN,
            "Mateusz",
            "User",
            "https://avatars.githubusercontent.com/u/28571918?v=4",
            LocalDateTime.of(2017,5,9,16,57,21),
            6.0);
}
