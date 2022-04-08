package io.github.arch2be.empex.application.usecases;

import io.github.arch2be.empex.application.dto.GithubUserDto;

import java.util.Optional;

public interface GetGithubUserInfoUseCase {

    Optional<GithubUserDto> findGithubUserByLogin(String login);
}
