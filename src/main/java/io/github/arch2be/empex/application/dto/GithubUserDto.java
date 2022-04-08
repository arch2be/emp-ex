package io.github.arch2be.empex.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GithubUserDto {
    Integer id;
    String login;
    String name;
    String type;
    String avatarUrl;
    LocalDateTime createdAt;
    Double calculations;
}
