package io.github.arch2be.empex.application.ports.in;

import io.github.arch2be.empex.application.dto.GithubUserDto;
import io.github.arch2be.empex.application.ports.out.LoadGithubUser;
import io.github.arch2be.empex.application.usecases.GetGithubUserInfoUseCase;
import io.github.arch2be.empex.common.UseCase;
import lombok.AllArgsConstructor;

import java.util.Optional;

@UseCase
@AllArgsConstructor
public class GetGithubUserInfoService implements GetGithubUserInfoUseCase {

    private final LoadGithubUser loadGithubUser;

    @Override
    public Optional<GithubUserDto> findGithubUserByLogin(String login) {
        return loadGithubUser.loadByLogin(login)
                .map(user -> GithubUserDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .login(user.getLogin())
                        .avatarUrl(user.getAvatarUrl())
                        .createdAt(user.getCreatedAt())
                        .type(user.getType())
                        .calculations(user.getCalculations())
                        .build());
    }
}
