package io.github.arch2be.empex.framework;

import lombok.Getter;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "github_user_audit_log")
@Getter
class GithubUserAuditLogEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String login;
    private Integer requestCount;

    @PersistenceConstructor
    public GithubUserAuditLogEntity() {
    }

    GithubUserAuditLogEntity(Long id, String login, Integer requestCount) {
        this.id = id;
        this.login = login;
        this.requestCount = requestCount;
    }
}
