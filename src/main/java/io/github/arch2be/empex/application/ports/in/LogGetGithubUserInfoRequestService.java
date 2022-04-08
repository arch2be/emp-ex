package io.github.arch2be.empex.application.ports.in;

import io.github.arch2be.empex.application.ports.out.GithubUserAuditLogRepository;
import io.github.arch2be.empex.application.usecases.LogGetGithubUserInfoRequestUseCase;
import io.github.arch2be.empex.common.UseCase;
import io.github.arch2be.empex.domain.GithubUserAuditLog;
import lombok.AllArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@AllArgsConstructor
public class LogGetGithubUserInfoRequestService implements LogGetGithubUserInfoRequestUseCase {

    private final GithubUserAuditLogRepository githubUserAuditLogRepository;

    @Override
    public void logInfoForLogin(String login) {
        doInTransaction(login);
    }

    @Transactional
    void doInTransaction(String login) {
        GithubUserAuditLog githubUserAuditLogToSave = githubUserAuditLogRepository.findGithubUserAuditLogByLogin(login)
                .map(GithubUserAuditLog::increment)
                .orElse(GithubUserAuditLog.withoutId(login));

        githubUserAuditLogRepository.save(githubUserAuditLogToSave);
    }
}
