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
                .map(user -> new GithubUserDto(user.getId(), user.getLogin(), user.getName(),
                        user.getType(), user.getAvatarUrl(), user.getCreatedAt(), user.getCalculations()));
    }
}
