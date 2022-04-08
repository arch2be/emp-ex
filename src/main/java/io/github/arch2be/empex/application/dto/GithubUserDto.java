package io.github.arch2be.empex.application.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GithubUserDto {
    Integer id;
    String login;
    String name;
    String type;
    String avatarUrl;
    LocalDateTime createdAt;
    Double calculations;

    public GithubUserDto(Integer id, String login, String name, String type, String avatarUrl, LocalDateTime createdAt, Double calculations) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.type = type;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.calculations = calculations;
    }
}
