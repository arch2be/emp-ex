package io.github.arch2be.empex.framework;

import io.github.arch2be.empex.application.ports.out.GithubUserAuditLogRepository;
import io.github.arch2be.empex.domain.GithubUserAuditLog;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
class GithubUserAuditLogJpaRepository implements GithubUserAuditLogRepository {

    private final GithubUserAuditLogRepo githubUserAuditLogRepository;

    @Override
    public Optional<GithubUserAuditLog> findGithubUserAuditLogByLogin(String login) {
        return githubUserAuditLogRepository.findOneByLogin(login)
                .map(entity -> GithubUserAuditLog.withId(entity.getId(), entity.getLogin(), entity.getRequestCount()));
    }

    @Override
    public void save(GithubUserAuditLog toSave) {
        githubUserAuditLogRepository.save(
                new GithubUserAuditLogEntity(toSave.getId(), toSave.getLogin(), toSave.getRequestCount()));
    }
}

@Repository
interface GithubUserAuditLogRepo extends JpaRepository<GithubUserAuditLogEntity, Long> {

    Optional<GithubUserAuditLogEntity> findOneByLogin(String login);
}
