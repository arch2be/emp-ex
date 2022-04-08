package io.github.arch2be.empex.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GithubUserAuditLog {

    private final Long id;
    private final String login;
    private final Integer requestCount;

    public static GithubUserAuditLog withoutId(String login) {
        return new GithubUserAuditLog(null, login, 1);
    }

    public static GithubUserAuditLog withId(Long id, String login, Integer requestCount) {
        return new GithubUserAuditLog(id, login, requestCount);
    }

    public GithubUserAuditLog increment() {
        return new GithubUserAuditLog(this.id, this.login, this.requestCount + 1);
    }
}
