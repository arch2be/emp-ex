package io.github.arch2be.empex.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class GithubUser {

    private final Integer id;
    private final String login;
    private final String type;
    private final String avatarUrl;
    private final LocalDateTime createdAt;
    private final String name;
    private final Double calculations;

    public static GithubUser of(Integer id, String login, String type,
                                String avatarUrl, LocalDateTime createdAt, String name,
                                Integer amountOfFollowers, Integer amountOfPublicRepos) {
        return new GithubUser(id, login, type, avatarUrl, createdAt,
                name, calculateCalculation(amountOfFollowers, amountOfPublicRepos));
    }

    private static Double calculateCalculation(Integer amountOfFollowers, Integer amountOfPublicRepos) {
        return BigDecimal.valueOf(6.0 / amountOfFollowers * (2.0 + amountOfPublicRepos))
                .setScale(4, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
