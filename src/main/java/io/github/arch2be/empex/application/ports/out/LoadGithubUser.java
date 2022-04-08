package io.github.arch2be.empex.application.ports.out;

import io.github.arch2be.empex.domain.GithubUser;

import java.util.Optional;

public interface LoadGithubUser {

    Optional<GithubUser> loadByLogin(String login);
}
