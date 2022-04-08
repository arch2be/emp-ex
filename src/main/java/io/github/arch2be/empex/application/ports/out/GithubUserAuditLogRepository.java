package io.github.arch2be.empex.application.ports.out;

import io.github.arch2be.empex.domain.GithubUserAuditLog;

import java.util.Optional;

public interface GithubUserAuditLogRepository {

    Optional<GithubUserAuditLog> findGithubUserAuditLogByLogin(String login);
    void save(GithubUserAuditLog toSave);
}
