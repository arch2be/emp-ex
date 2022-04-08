package io.github.arch2be.empex.framework;

import io.github.arch2be.empex.application.dto.GithubUserDto;
import io.github.arch2be.empex.application.usecases.GetGithubUserInfoUseCase;
import io.github.arch2be.empex.application.usecases.LogGetGithubUserInfoRequestUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
class GetGithubUserInfoController {

    private final GetGithubUserInfoUseCase getGithubUserInfoUseCase;
    private final LogGetGithubUserInfoRequestUseCase logGetGithubUserInfoRequestUseCase;

    @GetMapping(path = "/{login}")
    ResponseEntity<GithubUserDto> getGithubUserInfo(@PathVariable("login") String login) {
        Optional<GithubUserDto> githubUserByLogin = getGithubUserInfoUseCase.findGithubUserByLogin(login);

        if (githubUserByLogin.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        logGetGithubUserInfoRequestUseCase.logInfoForLogin(login);

        return ResponseEntity
                .ok(githubUserByLogin.get());
    }
}
