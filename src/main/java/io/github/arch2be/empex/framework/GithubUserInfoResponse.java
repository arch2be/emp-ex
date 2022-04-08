package io.github.arch2be.empex.framework;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
class GithubUserInfoResponse implements Serializable {
    String login;
    Integer id;
    String name;
    String type;
    Integer followers;

    @JsonProperty("avatar_url")
    String avatarUrl;

    @JsonProperty("created_at")
    LocalDateTime createdAt;

    @JsonProperty("public_repos")
    Integer publicRepos;

    public GithubUserInfoResponse() {
    }
}
