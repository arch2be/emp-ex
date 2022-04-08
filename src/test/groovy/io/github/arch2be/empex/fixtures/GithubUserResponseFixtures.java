package io.github.arch2be.empex.fixtures;

import io.github.arch2be.empex.application.dto.GithubUserDto;
import io.github.arch2be.empex.framework.GithubUserInfoResponse;

import java.time.LocalDateTime;

public class GithubUserResponseFixtures {

    public static String OCTOCAT_LOGIN = "octocat";
    public static GithubUserInfoResponse OCTOCAT_CORRECT_RESPONSE_FROM_GITHUB =
            GithubUserInfoResponse.builder()
                    .id(1)
                    .name("monalisa octocat")
                    .login(OCTOCAT_LOGIN)
                    .avatarUrl("https://github.com/images/error/octocat_happy.gif")
                    .createdAt(LocalDateTime.of(2008,1,14,4,33,35))
                    .followers(20)
                    .publicRepos(2)
                    .type("User")
                    .build();

    public static GithubUserDto OCTOCAT_CORRECT_RESPONSE_FROM_APP =
            GithubUserDto.builder()
                    .id(1)
                    .name("monalisa octocat")
                    .login(OCTOCAT_LOGIN)
                    .avatarUrl("https://github.com/images/error/octocat_happy.gif")
                    .createdAt(LocalDateTime.of(2008,1,14,4,33,35))
                    .type("User")
                    .calculations(1.2)
                    .build();

    public static final String NOT_FOUND_MSG_FROM_GITHUB =
            "404 Not Found: \"{\"message\":\"Not Found\",\"documentation_url\":\"https://docs.github.com/rest/reference/users#get-a-user\"}\"";

}
