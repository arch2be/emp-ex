package io.github.arch2be.empex.application;

import io.github.arch2be.empex.application.ports.out.GithubUserAuditLogRepository;
import io.github.arch2be.empex.domain.GithubUserAuditLog;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class InMemoryGithubUserAuditLogRepo implements GithubUserAuditLogRepository {

    Map<String, GithubUserAuditLog> githubUserAuditLogs = new HashMap<>();

    @Override
    public Optional<GithubUserAuditLog> findGithubUserAuditLogByLogin(String login) {
        return Optional.ofNullable(githubUserAuditLogs.get(login));
    }

    @Override
    public void save(GithubUserAuditLog toSave) {
         githubUserAuditLogs.put(toSave.getLogin(), toSave);
    }
}
