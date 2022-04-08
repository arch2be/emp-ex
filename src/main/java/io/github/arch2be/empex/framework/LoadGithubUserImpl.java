package io.github.arch2be.empex.framework;

import io.github.arch2be.empex.application.ports.out.LoadGithubUser;
import io.github.arch2be.empex.domain.GithubUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@Service
class LoadGithubUserImpl implements LoadGithubUser {

    private final RestTemplate restTemplate;
    @Value("${users.api.url}")
    private String githubURL;

    LoadGithubUserImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Optional<GithubUser> loadByLogin(String login) {
        try {
            ResponseEntity<GithubUserInfoResponse> response =
                    restTemplate.getForEntity(URI.create(githubURL + login), GithubUserInfoResponse.class);

            return mapToDomainObject(Objects.requireNonNull(response.getBody()));
        } catch (RestClientException e) {
            return Optional.empty();
        }
    }

    private Optional<GithubUser> mapToDomainObject(GithubUserInfoResponse response) {
        return Optional.of(
                GithubUser.of(response.getId(), response.getLogin(), response.getType(), response.getAvatarUrl(),
                        response.getCreatedAt(), response.getName(), response.getFollowers(), response.getPublicRepos()));
    }
}
