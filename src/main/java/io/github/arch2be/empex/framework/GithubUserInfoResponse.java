package io.github.arch2be.empex.framework;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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


}
