package io.github.arch2be.empex.fixtures;

import io.github.arch2be.empex.domain.GithubUserAuditLog;

public class GithubUserAuditLogFixtures {

    public static String ARCH2BE_LOGIN = "arch2be";
    public static GithubUserAuditLog ARCH2BE_RECORD = GithubUserAuditLog.withId(1L, ARCH2BE_LOGIN, 1);
}
