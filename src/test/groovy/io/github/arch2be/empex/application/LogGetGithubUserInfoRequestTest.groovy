package io.github.arch2be.empex.application

import io.github.arch2be.empex.application.ports.in.LogGetGithubUserInfoRequestService
import io.github.arch2be.empex.application.ports.out.GithubUserAuditLogRepository
import io.github.arch2be.empex.application.usecases.LogGetGithubUserInfoRequestUseCase
import io.github.arch2be.empex.domain.GithubUserAuditLog
import io.github.arch2be.empex.fixtures.GithubUserAuditLogFixtures
import spock.lang.Specification

class LogGetGithubUserInfoRequestTest extends Specification {

    GithubUserAuditLogRepository repository
    LogGetGithubUserInfoRequestUseCase logGetGithubUserInfoRequestUseCase

    def "should for new login create new record with requestCount = 1"() {
        given:
            thereIsANewServiceWithEmptyDb()
        when:
            logGetGithubUserInfoRequestUseCase.logInfoForLogin(GithubUserAuditLogFixtures.ARCH2BE_LOGIN)
        then:
            Optional<GithubUserAuditLog> result = repository.findGithubUserAuditLogByLogin(GithubUserAuditLogFixtures.ARCH2BE_LOGIN)
            result.isPresent()
            result.get().login == GithubUserAuditLogFixtures.ARCH2BE_LOGIN
            result.get().requestCount == 1
    }

    def "should for existing login save record with requestCount = 2"() {
        given:
            thereIsANewServiceWithEmptyDb()
            thereIsADatabaseWithRecord(GithubUserAuditLogFixtures.ARCH2BE_RECORD)
        when:
            logGetGithubUserInfoRequestUseCase.logInfoForLogin(GithubUserAuditLogFixtures.ARCH2BE_LOGIN)
        then:
            Optional<GithubUserAuditLog> result = repository.findGithubUserAuditLogByLogin(GithubUserAuditLogFixtures.ARCH2BE_LOGIN)
            result.isPresent()
            result.get().login == GithubUserAuditLogFixtures.ARCH2BE_LOGIN
            result.get().requestCount == 2
    }

    void thereIsADatabaseWithRecord(GithubUserAuditLog record) {
        repository.save(record)
    }

    void thereIsANewServiceWithEmptyDb() {
        repository = new InMemoryGithubUserAuditLogRepo()
        logGetGithubUserInfoRequestUseCase = new LogGetGithubUserInfoRequestService(repository)
    }
}
