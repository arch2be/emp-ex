package io.github.arch2be.empex.framework;

import io.github.arch2be.empex.application.ports.out.GithubUserAuditLogRepository;
import io.github.arch2be.empex.domain.GithubUserAuditLog;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
class GithubUserAuditLogRepositoryImpl implements GithubUserAuditLogRepository {

    private final GithubUserAuditLogJpaRepository githubUserAuditLogJpaRepository;

    @Override
    public Optional<GithubUserAuditLog> findGithubUserAuditLogByLogin(String login) {
        return githubUserAuditLogJpaRepository.findOneByLogin(login)
                .map(entity -> GithubUserAuditLog.withId(entity.getId(), entity.getLogin(), entity.getRequestCount()));
    }

    @Override
    public void save(GithubUserAuditLog toSave) {
        githubUserAuditLogJpaRepository.save(
                new GithubUserAuditLogEntity(toSave.getId(), toSave.getLogin(), toSave.getRequestCount()));
    }
}
