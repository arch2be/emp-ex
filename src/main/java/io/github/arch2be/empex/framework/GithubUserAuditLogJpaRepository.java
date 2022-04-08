package io.github.arch2be.empex.framework;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface GithubUserAuditLogJpaRepository extends JpaRepository<GithubUserAuditLogEntity, Long> {

    Optional<GithubUserAuditLogEntity> findOneByLogin(String login);
}
